package filtro;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jwt.TokenResponse;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Obtener la ruta del recurso solicitado
        String path = requestContext.getUriInfo().getPath();
        // Excluir el endpoint de login del filtro de autenticación
        if (path.equals("login")) {
            return;
        }
        String token = getTokenFromHeaders(requestContext.getHeaderString(HttpHeaders.AUTHORIZATION));
        if (token == null || !isValidToken(token)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    public static boolean isValidToken(String token) {
        try {
            String username = TokenResponse.getUsernameFromToken(token);
            return username != null;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (JwtException e) {
            return false;
        }
    }

    public  String getTokenFromHeaders(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Elimina el prefijo "Bearer "
        }
        return null;
    }
}