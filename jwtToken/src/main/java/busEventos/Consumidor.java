package busEventos;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class Consumidor {

    private static final String NOMBRE_INTERCAMBIO = "cita";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory fabrica = new ConnectionFactory();
        fabrica.setHost("localhost");
        Connection conexion = fabrica.newConnection();
        Channel canal = conexion.createChannel();

        canal.exchangeDeclare(NOMBRE_INTERCAMBIO, "fanout");
        String nombreCola = canal.queueDeclare().getQueue();
        canal.queueBind(nombreCola, NOMBRE_INTERCAMBIO, "");

        System.out.println(" [*] Esperando mensajes.");

        ExecutorService executor = Executors.newFixedThreadPool(5); // Pool de 5 hilos

        while (true) {
            executor.submit(() -> {
                try {
                    Consumer consumer = new DefaultConsumer(canal) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                            JSONObject json = new JSONObject(new String(body, "UTF-8"));
                            System.out.println(" [x] JSON Recibido: " + json.toString());
                        }
                    };
                    canal.basicConsume(nombreCola, true, consumer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(1000); 
        }
    }
}