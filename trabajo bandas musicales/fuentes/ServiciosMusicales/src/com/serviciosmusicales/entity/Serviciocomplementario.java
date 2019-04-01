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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hogar
 */
@Entity
@Table(name = "serviciocomplementario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviciocomplementario.findAll", query = "SELECT s FROM Serviciocomplementario s")
    , @NamedQuery(name = "Serviciocomplementario.findByIdComple", query = "SELECT s FROM Serviciocomplementario s WHERE s.idComple = :idComple")
    , @NamedQuery(name = "Serviciocomplementario.findByDescripcion", query = "SELECT s FROM Serviciocomplementario s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Serviciocomplementario.findByValor", query = "SELECT s FROM Serviciocomplementario s WHERE s.valor = :valor")})
public class Serviciocomplementario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComple")
    private Integer idComple;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private BigInteger valor;
    @JoinTable(name = "solicitudservicioscomp", joinColumns = {
        @JoinColumn(name = "idServicioCompl", referencedColumnName = "idComple")}, inverseJoinColumns = {
        @JoinColumn(name = "idsolicitud", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Solicitud> solicitudCollection;
    @JoinColumn(name = "solicitud", referencedColumnName = "id")
    @ManyToOne
    private Solicitud solicitud;

    public Serviciocomplementario() {
    }

    public Serviciocomplementario(Integer idComple) {
        this.idComple = idComple;
    }

    public Integer getIdComple() {
        return idComple;
    }

    public void setIdComple(Integer idComple) {
        this.idComple = idComple;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComple != null ? idComple.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviciocomplementario)) {
            return false;
        }
        Serviciocomplementario other = (Serviciocomplementario) object;
        if ((this.idComple == null && other.idComple != null) || (this.idComple != null && !this.idComple.equals(other.idComple))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.serviciosmusicales.entity.Serviciocomplementario[ idComple=" + idComple + " ]";
    }
    
}
