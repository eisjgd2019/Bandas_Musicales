package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Serviciocomplementario;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ { 

    public static volatile SingularAttribute<Solicitud, Date> fechaEvento;
    public static volatile SingularAttribute<Solicitud, BigInteger> valorTrasporte;
    public static volatile SingularAttribute<Solicitud, Date> fechaSolicitud;
    public static volatile CollectionAttribute<Solicitud, Serviciocomplementario> serviciocomplementarioCollection;
    public static volatile SingularAttribute<Solicitud, String> direccionEvento;
    public static volatile CollectionAttribute<Solicitud, Serviciocomplementario> serviciocomplementarioCollection1;
    public static volatile SingularAttribute<Solicitud, Integer> cantHoras;
    public static volatile SingularAttribute<Solicitud, Long> id;
    public static volatile SingularAttribute<Solicitud, Integer> horaInicio;

}