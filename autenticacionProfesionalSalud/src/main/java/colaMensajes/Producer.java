package colaMensajes;

import cifrado.CifradoInformacionSin;
import cifrado.ICifrado;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

public class Producer {

    private static final String QUEUE_NAME = "autenticacionProfesonalSalud";
    private static final ICifrado cifrado = CifradoInformacionSin.getInstance();
    public static void publicarCola(String jsonData) {
        JSONObject json = new JSONObject(jsonData);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // Declare the queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            String message = cifrado.CifrarMensaje(json.toString());

            // Publish the JSON string to the queue
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] JSON Enviado: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
