/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hogar
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findById", query = "SELECT s FROM Solicitud s WHERE s.id = :id")
    , @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Solicitud.findByFechaEvento", query = "SELECT s FROM Solicitud s WHERE s.fechaEvento = :fechaEvento")
    , @NamedQuery(name = "Solicitud.findByHoraInicio", query = "SELECT s FROM Solicitud s WHERE s.horaInicio = :horaInicio")
    , @NamedQuery(name = "Solicitud.findByCantHoras", query = "SELECT s FROM Solicitud s WHERE s.cantHoras = :cantHoras")
    , @NamedQuery(name = "Solicitud.findByDireccionEvento", query = "SELECT s FROM Solicitud s WHERE s.direccionEvento = :direccionEvento")
    , @NamedQuery(name = "Solicitud.findByValorTrasporte", query = "SELECT s FROM Solicitud s WHERE s.valorTrasporte = :valorTrasporte")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "fechaEvento")
    @Temporal(TemporalType.DATE)
    private Date fechaEvento;
    @Column(name = "horaInicio")
    private Integer horaInicio;
    @Column(name = "cantHoras")
    private Integer cantHoras;
    @Column(name = "direccionEvento")
    private String direccionEvento;
    @Column(name = "valorTrasporte")
    private BigInteger valorTrasporte;
    @ManyToMany(mappedBy = "solicitudCollection")
    private Collection<Serviciocomplementario> serviciocomplementarioCollection;
    @OneToMany(mappedBy = "solicitud")
    private Collection<Serviciocomplementario> serviciocomplementarioCollection1;

    public Solicitud() {
    }

    public Solicitud(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Integer getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(Integer cantHoras) {
        this.cantHoras = cantHoras;
    }

    public String getDireccionEvento() {
        return direccionEvento;
    }

    public void setDireccionEvento(String direccionEvento) {
        this.direccionEvento = direccionEvento;
    }

    public BigInteger getValorTrasporte() {
        return valorTrasporte;
    }

    public void setValorTrasporte(BigInteger valorTrasporte) {
        this.valorTrasporte = valorTrasporte;
    }

    @XmlTransient
    public Collection<Serviciocomplementario> getServiciocomplementarioCollection() {
        return serviciocomplementarioCollection;
    }

    public void setServiciocomplementarioCollection(Collection<Serviciocomplementario> serviciocomplementarioCollection) {
        this.serviciocomplementarioCollection = serviciocomplementarioCollection;
    }

    @XmlTransient
    public Collection<Serviciocomplementario> getServiciocomplementarioCollection1() {
        return serviciocomplementarioCollection1;
    }

    public void setServiciocomplementarioCollection1(Collection<Serviciocomplementario> serviciocomplementarioCollection1) {
        this.serviciocomplementarioCollection1 = serviciocomplementarioCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.serviciosmusicales.entity.Solicitud[ id=" + id + " ]";
    }
    
}
