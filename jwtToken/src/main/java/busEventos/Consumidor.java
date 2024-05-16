package busEventos;

import SistemaCitas.Cita;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    Consumer consumer;
                    consumer = new DefaultConsumer(canal) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                            JSONObject json = new JSONObject(new String(body, "UTF-8"));
                            JSONObject fechaCitaJson = json.getJSONObject("fechaCita");
                            int year = json.getInt("year");
                            int month = json.getInt("month");
                            int day = json.getInt("day");
                            int hour = json.getInt("hour");
                            int minute = json.getInt("minute");
                            Calendar fechaCita = Calendar.getInstance();
                            fechaCita.set(year, month, day, hour, minute);
                            Cita cita = new Cita(
                                    json.getInt("idCita"),
                                    fechaCita,
                                    json.getInt("idMedico"),
                                    json.getInt("idPaciente")
                            );

                            System.out.println("Objeto Java creado:");
                            System.out.println(cita);
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
