package busEventos;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

public class PublicarEvento {

    private static final String NOMBRE_INTERCAMBIO = "expediente";

//    public static void main(String[] argv) throws Exception {
//        ConnectionFactory fabrica = new ConnectionFactory();
//        fabrica.setHost("localhost");
//        try (Connection conexion = fabrica.newConnection(); Channel canal = conexion.createChannel()) {
//            canal.exchangeDeclare(NOMBRE_INTERCAMBIO, "fanout");
//
//            JSONObject json = new JSONObject();
//            json.put("clave1", "valor1");
//            json.put("clave2", "valor2");
//            String mensaje = json.toString();
//
//            canal.basicPublish(NOMBRE_INTERCAMBIO, "", null, mensaje.getBytes("UTF-8"));
//            System.out.println(" [x] JSON Enviado: " + mensaje);
//        }
//    }
    public static void publicarEvento(String jsonData) {
        JSONObject json = new JSONObject(jsonData);

        ConnectionFactory fabrica = new ConnectionFactory();
        fabrica.setHost("localhost");
        try (Connection conexion = fabrica.newConnection(); Channel canal = conexion.createChannel()) {
            canal.exchangeDeclare(NOMBRE_INTERCAMBIO, "fanout");

            String mensaje = json.toString();

            canal.basicPublish(NOMBRE_INTERCAMBIO, "", null, mensaje.getBytes("UTF-8"));
            System.out.println(" [x] JSON Enviado: " + mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
