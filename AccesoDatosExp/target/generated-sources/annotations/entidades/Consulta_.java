package entidades;

import entidades.ExpedientePaciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-10T17:43:54", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Consulta.class)
public class Consulta_ { 

    public static volatile ListAttribute<Consulta, ExpedientePaciente> expedientePacienteList;
    public static volatile SingularAttribute<Consulta, String> receta;
    public static volatile SingularAttribute<Consulta, String> diagnostico;
    public static volatile SingularAttribute<Consulta, Integer> idConsulta;
    public static volatile SingularAttribute<Consulta, String> sintomas;

}