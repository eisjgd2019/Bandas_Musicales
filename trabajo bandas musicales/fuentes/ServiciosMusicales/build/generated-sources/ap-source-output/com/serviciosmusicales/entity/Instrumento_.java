package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Generomusical;
import com.serviciosmusicales.entity.Musico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Instrumento.class)
public class Instrumento_ { 

    public static volatile CollectionAttribute<Instrumento, Generomusical> generomusicalCollection;
    public static volatile SingularAttribute<Instrumento, String> instrumento;
    public static volatile SingularAttribute<Instrumento, Integer> codigoInstrumento;
    public static volatile CollectionAttribute<Instrumento, Musico> musicoCollection;

}