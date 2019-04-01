package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Instrumento;
import com.serviciosmusicales.entity.Persona;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Musico.class)
public class Musico_ { 

    public static volatile SingularAttribute<Musico, Integer> estado;
    public static volatile CollectionAttribute<Musico, Instrumento> instrumentoCollection;
    public static volatile SingularAttribute<Musico, Persona> persona;
    public static volatile SingularAttribute<Musico, BigInteger> precioHora;
    public static volatile SingularAttribute<Musico, String> identificacion;

}