package interfaces;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public interface IRestProfesionalSalud {

    Response getRecurso(@Context HttpHeaders headers);

    Response setRecurso(@Context HttpHeaders headers, String data);

    Response setRecurso(@Context HttpHeaders headers);

    Response updateRecurso(@Context HttpHeaders headers);

    Response deleteRecurso(@Context HttpHeaders headers);
}
