package com.itson.edu.mx.entidades;

import com.itson.edu.mx.entidades.CitaPaciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-12T23:18:33", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> cedulaProfesional;
    public static volatile SingularAttribute<Medico, Integer> idMedico;
    public static volatile ListAttribute<Medico, CitaPaciente> citaPacienteList;
    public static volatile SingularAttribute<Medico, String> nombre;

}