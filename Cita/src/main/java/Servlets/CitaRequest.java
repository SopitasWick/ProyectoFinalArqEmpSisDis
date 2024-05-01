/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Negocio.Usuario;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/citaRequest")
public class CitaRequest extends HttpServlet {
 //AGREGARLE UNA INTERFACE
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Establecer el tipo de contenido como JSON
        response.setContentType("application/json");

        // Leer el cuerpo de la solicitud JSON
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }

        // Convertir el JSON recibido a un objeto CompraRequest
        Gson gson = new Gson();
        Usuario usuarioRequest = gson.fromJson(jsonBuilder.toString(), Usuario.class);
        
        //Hacer procedimiento necesario para generar la cita
        
        //Checar si usar rabbit o llamadas rest
        
        // Convertir el objeto compra a JSON
        String jsonCompra = gson.toJson(usuarioRequest);
         
        // Escribir la respuesta JSON
        PrintWriter out = response.getWriter();
        out.println(jsonCompra);//ESTO NO VA ASI, POR QUE SE ENVIA LA RESPUESTA AL CLIENTE QUE HIZO LA PETICION
        out.println("Se redirigio con exito la purchaseRequest a la aplicacion PurchaseService");
        
        
    }

}
