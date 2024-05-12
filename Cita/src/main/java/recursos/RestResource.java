package recursos;

import filtro.AuthenticationFilter;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.Key;
import modelos.LoginRequest;
import jwt.TokenResponse;

@Path("api")
public class RestResource {

    private static final Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    @GET
    @Path("recurso")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response getRecurso(@Context HttpHeaders headers) {
        String token = getTokenFromHeaders(headers);
        if (AuthenticationFilter.isValidToken(token)) {
            // El token es válido, procede a obtener los datos del recurso
            // Aquí iría la lógica para obtener el recurso solicitado
            return Response.ok("{\"message\": \"Recursos obtenidos exitosamente\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\": \"Token inválido\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @POST
    @Path("recurso")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response setRecurso(@Context HttpHeaders headers) {
        String token = getTokenFromHeaders(headers);
        if (AuthenticationFilter.isValidToken(token)) {
            // El token es válido, procede a obtener los datos del recurso
            // Aquí iría la lógica para obtener el recurso solicitado
            return Response.ok("{\"message\": \"Recursos obtenidos exitosamente\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\": \"Token inválido\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    // Otros métodos para implementar los endpoints POST, DELETE y PUT
    private String getTokenFromHeaders(HttpHeaders headers) {
        String token = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7); // Elimina el prefijo "Bearer "
        }
        return null;
    }
}