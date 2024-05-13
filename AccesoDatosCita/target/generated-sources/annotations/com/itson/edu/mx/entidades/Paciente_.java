package com.itson.edu.mx.entidades;

import com.itson.edu.mx.entidades.CitaPaciente;
import com.itson.edu.mx.entidades.PacienteTutor;
import com.itson.edu.mx.entidades.UsuarioPaciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-12T23:18:33", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Integer> idPaciente;
    public static volatile ListAttribute<Paciente, UsuarioPaciente> usuarioPacienteList;
    public static volatile SingularAttribute<Paciente, Integer> idExpediente;
    public static volatile ListAttribute<Paciente, CitaPaciente> citaPacienteList;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, Integer> edad;
    public static volatile ListAttribute<Paciente, PacienteTutor> pacienteTutorList;

}