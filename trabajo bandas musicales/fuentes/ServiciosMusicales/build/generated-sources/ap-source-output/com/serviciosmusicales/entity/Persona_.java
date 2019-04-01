package com.serviciosmusicales.entity;

import com.serviciosmusicales.entity.Musico;
import com.serviciosmusicales.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T12:56:37")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> identificacion;
    public static volatile SingularAttribute<Persona, String> nombreCompleto;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile CollectionAttribute<Persona, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Persona, Musico> musico;

}