package com.itson.edu.mx.entidades;

import com.itson.edu.mx.entidades.Medico;
import com.itson.edu.mx.entidades.Paciente;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-10T17:43:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(CitaPaciente.class)
public class CitaPaciente_ { 

    public static volatile SingularAttribute<CitaPaciente, Integer> idCita;
    public static volatile SingularAttribute<CitaPaciente, Paciente> idPaciente;
    public static volatile SingularAttribute<CitaPaciente, Date> fecha;
    public static volatile SingularAttribute<CitaPaciente, Medico> idMedico;

}