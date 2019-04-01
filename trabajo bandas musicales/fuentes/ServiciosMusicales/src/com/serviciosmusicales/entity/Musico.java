/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hogar
 */
@Entity
@Table(name = "musico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musico.findAll", query = "SELECT m FROM Musico m")
    , @NamedQuery(name = "Musico.findByIdentificacion", query = "SELECT m FROM Musico m WHERE m.identificacion = :identificacion")
    , @NamedQuery(name = "Musico.findByEstado", query = "SELECT m FROM Musico m WHERE m.estado = :estado")
    , @NamedQuery(name = "Musico.findByPrecioHora", query = "SELECT m FROM Musico m WHERE m.precioHora = :precioHora")})
public class Musico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "precioHora")
    private BigInteger precioHora;
    @ManyToMany(mappedBy = "musicoCollection")
    private Collection<Instrumento> instrumentoCollection;
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Musico() {
    }

    public Musico(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public BigInteger getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigInteger precioHora) {
        this.precioHora = precioHora;
    }

    @XmlTransient
    public Collection<Instrumento> getInstrumentoCollection() {
        return instrumentoCollection;
    }

    public void setInstrumentoCollection(Collection<Instrumento> instrumentoCollection) {
        this.instrumentoCollection = instrumentoCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musico)) {
            return false;
        }
        Musico other = (Musico) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.serviciosmusicales.entity.Musico[ identificacion=" + identificacion + " ]";
    }
    
}
