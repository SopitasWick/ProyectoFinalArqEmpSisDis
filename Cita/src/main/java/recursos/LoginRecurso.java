package recursos;

import modelos.*;
import jwt.TokenResponse;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelos.LoginRequest;

@Path("login")
public class LoginRecurso {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response login(LoginRequest loginRequest) {
        if (isValidCredentials(loginRequest.getUsername(), loginRequest.getPassword())) {
            System.out.println("111"+loginRequest.getUsername());
            String token = TokenResponse.generateToken(loginRequest.getUsername());
            System.out.println("tokennn"+token);
            String jsonResponse = "{\"token\": \"" + token + "\"}";
            return Response.ok(jsonResponse).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Credenciales incorrectas\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Validar las credenciales
        return username.equals("usuario") && password.equals("contraseña");
    }
}