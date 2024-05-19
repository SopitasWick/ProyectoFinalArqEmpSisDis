/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrado;

/**
 *
 * @author DELL
 */
public class pruebaCifrado {
    public static void main(String args[]){
        String citaJson = "{\n"
                + "  \"idCita\": 1,\n"
                + "  \"fechaCita\": {\n"
                + "    \"year\": 2024,\n"
                + "    \"month\": 4,\n"
                + "    \"day\": 16,\n"
                + "    \"hour\": 12,\n"
                + "    \"minute\": 0\n"
                + "  },\n"
                + "  \"idMedico\": 123,\n"
                + "  \"idPaciente\": 456\n"
                + "}";
        ICifrado cifrado = CifradoInformacionSin.getInstance();
        //String mensajeOriginal = "Si pasaremos distribuidos, animo";
        String mensajeCifrado =   cifrado.CifrarMensaje(citaJson);
        String mensajeDescifrado = cifrado.descifrarMensaje(mensajeCifrado);
        
         System.out.println("Mensaje original: " + citaJson);
         System.out.println("Mensaje cifrado: " + mensajeCifrado);
         System.out.println("Mensaje descifrado: " + mensajeDescifrado);
      
        
       
        
    }
}
