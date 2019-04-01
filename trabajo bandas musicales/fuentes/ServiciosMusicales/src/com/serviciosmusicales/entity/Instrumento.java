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
@Table(name = "instrumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instrumento.findAll", query = "SELECT i FROM Instrumento i")
    , @NamedQuery(name = "Instrumento.findByCodigoInstrumento", query = "SELECT i FROM Instrumento i WHERE i.codigoInstrumento = :codigoInstrumento")
    , @NamedQuery(name = "Instrumento.findByInstrumento", query = "SELECT i FROM Instrumento i WHERE i.instrumento = :instrumento")})
public class Instrumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoInstrumento")
    private Integer codigoInstrumento;
    @Column(name = "instrumento")
    private String instrumento;
    @ManyToMany(mappedBy = "instrumentoCollection")
    private Collection<Generomusical> generomusicalCollection;
    @JoinTable(name = "instrumentomusico", joinColumns = {
        @JoinColumn(name = "codigoInstrumento", referencedColumnName = "codigoInstrumento")}, inverseJoinColumns = {
        @JoinColumn(name = "Identificacion", referencedColumnName = "identificacion")})
    @ManyToMany
    private Collection<Musico> musicoCollection;

    public Instrumento() {
    }

    public Instrumento(Integer codigoInstrumento) {
        this.codigoInstrumento = codigoInstrumento;
    }

    public Integer getCodigoInstrumento() {
        return codigoInstrumento;
    }

    public void setCodigoInstrumento(Integer codigoInstrumento) {
        this.codigoInstrumento = codigoInstrumento;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @XmlTransient
    public Collection<Generomusical> getGeneromusicalCollection() {
        return generomusicalCollection;
    }

    public void setGeneromusicalCollection(Collection<Generomusical> generomusicalCollection) {
        this.generomusicalCollection = generomusicalCollection;
    }

    @XmlTransient
    public Collection<Musico> getMusicoCollection() {
        return musicoCollection;
    }

    public void setMusicoCollection(Collection<Musico> musicoCollection) {
        this.musicoCollection = musicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInstrumento != null ? codigoInstrumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumento)) {
            return false;
        }
        Instrumento other = (Instrumento) object;
        if ((this.codigoInstrumento == null && other.codigoInstrumento != null) || (this.codigoInstrumento != null && !this.codigoInstrumento.equals(other.codigoInstrumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.serviciosmusicales.entity.Instrumento[ codigoInstrumento=" + codigoInstrumento + " ]";
    }
    
}
