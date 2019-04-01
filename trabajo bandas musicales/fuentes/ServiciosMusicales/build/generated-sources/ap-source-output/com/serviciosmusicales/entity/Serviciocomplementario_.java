package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Solicitud;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Serviciocomplementario.class)
public class Serviciocomplementario_ { 

    public static volatile SingularAttribute<Serviciocomplementario, String> descripcion;
    public static volatile CollectionAttribute<Serviciocomplementario, Solicitud> solicitudCollection;
    public static volatile SingularAttribute<Serviciocomplementario, Solicitud> solicitud;
    public static volatile SingularAttribute<Serviciocomplementario, BigInteger> valor;
    public static volatile SingularAttribute<Serviciocomplementario, Integer> idComple;

}