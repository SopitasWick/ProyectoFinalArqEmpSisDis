package recursos;

import busEventos.PublicarEvento;
import filtro.AuthenticationFilter;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import interfaces.IRestExpediente;

@Path("api")
public class RestExpediente implements IRestExpediente {

    @GET
    @Path("/recurso/expediente")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Override
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
    @Path("/evento/expediente")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Override
    public Response setRecurso(@Context HttpHeaders headers, String data) {
        String token = getTokenFromHeaders(headers);
        if (AuthenticationFilter.isValidToken(token)) {
            try {
                PublicarEvento.publicarEvento(data);
            } catch (Exception e) {
            }
            return Response.ok("{\"message\": \"Recursos obtenidos exitosamente\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\": \"Token inválido\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @POST
    @Path("/recurso/expediente")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Override
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

    @PUT
    @Path("/recurso/expediente")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Override
    public Response updateRecurso(@Context HttpHeaders headers) {
        String token = getTokenFromHeaders(headers);
        if (AuthenticationFilter.isValidToken(token)) {
            // El token es válido, procede a actualizar los datos del recurso
            // Aquí iría la lógica para actualizar el recurso solicitado
            return Response.ok("{\"message\": \"Recurso actualizado exitosamente\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\": \"Token inválido\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @DELETE
    @Path("/recurso/expediente")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Override
    public Response deleteRecurso(@Context HttpHeaders headers) {
        String token = getTokenFromHeaders(headers);
        if (AuthenticationFilter.isValidToken(token)) {
            // El token es válido, procede a eliminar los datos del recurso
            // Aquí iría la lógica para eliminar el recurso solicitado
            return Response.ok("{\"message\": \"Recurso eliminado exitosamente\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\": \"Token inválido\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    private String getTokenFromHeaders(HttpHeaders headers) {
        String token = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
}
