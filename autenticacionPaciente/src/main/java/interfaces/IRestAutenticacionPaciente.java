/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author DELL
 */
public interface IRestAutenticacionPaciente {
     public Response getRecurso(@Context HttpHeaders headers);
     public Response setRecurso(@Context HttpHeaders headers, String data);
     public Response setRecurso(@Context HttpHeaders headers);
     public Response updateRecurso(@Context HttpHeaders headers);
     public Response deleteRecurso(@Context HttpHeaders headers);
}
