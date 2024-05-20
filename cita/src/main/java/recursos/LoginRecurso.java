package recursos;

import interfaces.ILoginRecurso;
import jwt.TokenResponse;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelos.LoginRequest;
import tareaProgramada.notificacionAcceso;

@Path("login")
public class LoginRecurso implements ILoginRecurso{

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    @Override
    public Response login(LoginRequest loginRequest){
        System.out.println(loginRequest);
        if (isValidCredentials(loginRequest.getUsername(), loginRequest.getPassword())) {
            String token = TokenResponse.generateToken(loginRequest.getUsername());
            String jsonResponse = "{\"token\": \"" + token + "\", \"notificacion\": \"" + notificacionAcceso.ejecutarTareaPrueba() + "\" }";

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
        return username.equals("usuario") && password.equals("contra");
    }
}
