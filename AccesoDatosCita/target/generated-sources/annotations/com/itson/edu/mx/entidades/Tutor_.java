package com.itson.edu.mx.entidades;

import com.itson.edu.mx.entidades.PacienteTutor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-12T23:18:33", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tutor.class)
public class Tutor_ { 

    public static volatile SingularAttribute<Tutor, Integer> idTutor;
    public static volatile SingularAttribute<Tutor, String> parentesco;
    public static volatile SingularAttribute<Tutor, String> nombre;
    public static volatile ListAttribute<Tutor, PacienteTutor> pacienteTutorList;

}