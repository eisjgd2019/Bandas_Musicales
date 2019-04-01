/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.entity;

import java.io.Serializable;
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
@Table(name = "generomusical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generomusical.findAll", query = "SELECT g FROM Generomusical g")
    , @NamedQuery(name = "Generomusical.findByCodigo", query = "SELECT g FROM Generomusical g WHERE g.codigo = :codigo")
    , @NamedQuery(name = "Generomusical.findByNombre", query = "SELECT g FROM Generomusical g WHERE g.nombre = :nombre")})
public class Generomusical implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "generoinstrumentos", joinColumns = {
        @JoinColumn(name = "codigoGenero", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "codigoInstrumento", referencedColumnName = "codigoInstrumento")})
    @ManyToMany
    private Collection<Instrumento> instrumentoCollection;

    public Generomusical() {
    }

    public Generomusical(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Instrumento> getInstrumentoCollection() {
        return instrumentoCollection;
    }

    public void setInstrumentoCollection(Collection<Instrumento> instrumentoCollection) {
        this.instrumentoCollection = instrumentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generomusical)) {
            return false;
        }
        Generomusical other = (Generomusical) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.serviciosmusicales.entity.Generomusical[ codigo=" + codigo + " ]";
    }
    
}
