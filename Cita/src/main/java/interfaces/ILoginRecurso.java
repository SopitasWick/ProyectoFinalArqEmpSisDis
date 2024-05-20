/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import jakarta.ws.rs.core.Response;
import modelos.LoginRequest;

/**
 *
 * @author DELL
 */
public interface ILoginRecurso {
public Response login(LoginRequest loginRequest);
}
