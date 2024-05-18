//package colaMensajes;
//
//import SistemaCitas.Cita;
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Calendar;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.json.JSONObject;
//
//public class Consumer {
//
//    private static String QUEUE = "cita";
//
//    public static void main(String[] args) throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(QUEUE, false, false, false, null);
//        System.out.println("Waiting for messages. To exit press CTRL+C");
//
//        ExecutorService executor = Executors.newFixedThreadPool(5); // Pool de 5 hilos
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
//            System.out.println("Received '" + message + "'");
//
//            JSONObject json = new JSONObject(message);
//            int idCita = json.getInt("idCita");
//            JSONObject fechaCitaJson = json.getJSONObject("fechaCita");
//            int year = fechaCitaJson.getInt("year");
//            int month = fechaCitaJson.getInt("month");
//            int day = fechaCitaJson.getInt("day");
//            int hour = fechaCitaJson.getInt("hour");
//            int minute = fechaCitaJson.getInt("minute");
//            Calendar fechaCita = Calendar.getInstance();
//            fechaCita.set(year, month, day, hour, minute);
//            int idMedico = json.getInt("idMedico");
//            int idPaciente = json.getInt("idPaciente");
//
//            Cita cita = new Cita(idCita, fechaCita, idMedico, idPaciente);
//
//            System.out.println("Objeto Java creado:");
//            System.out.println(cita);
//            System.out.println(" [x] JSON Recibido: " + json.toString());
//        };
//
//        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> {
//        });
//
//    }
//}
