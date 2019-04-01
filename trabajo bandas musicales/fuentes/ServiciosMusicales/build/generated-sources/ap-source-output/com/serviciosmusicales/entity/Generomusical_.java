package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Instrumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Generomusical.class)
public class Generomusical_ { 

    public static volatile SingularAttribute<Generomusical, Integer> codigo;
    public static volatile CollectionAttribute<Generomusical, Instrumento> instrumentoCollection;
    public static volatile SingularAttribute<Generomusical, String> nombre;

}