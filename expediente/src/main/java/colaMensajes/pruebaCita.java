package colaMensajes;

public class pruebaCita {

    public static void main(String[] args) {
        String citaJson = "{\n"
                + "  \"idCita\": 1,\n"
                + "  \"fechaCita\": {\n"
                + "    \"year\": 2024,\n"
                + "    \"month\": 4,\n"
                + // Nota: Los meses en Calendar van de 0 a 11
                "    \"day\": 16,\n"
                + "    \"hour\": 12,\n"
                + "    \"minute\": 0\n"
                + "  },\n"
                + "  \"idMedico\": 123,\n"
                + "  \"idPaciente\": 456\n"
                + "}";
        Producer.publicarCola(citaJson);
        System.out.println("Evento publicado exitosamente.");
    }

}
