/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HerneyGil
 */
@Entity
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pais p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Pais.findByCodPaisDane", query = "SELECT p FROM Pais p WHERE p.codPaisDane = :codPaisDane"),
    @NamedQuery(name = "Pais.findByNombrePais", query = "SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais"),
    @NamedQuery(name = "Pais.findByCodIso", query = "SELECT p FROM Pais p WHERE p.codIso = :codIso"),
    @NamedQuery(name = "Pais.findByLongitud", query = "SELECT p FROM Pais p WHERE p.longitud = :longitud"),
    @NamedQuery(name = "Pais.findByLatitud", query = "SELECT p FROM Pais p WHERE p.latitud = :latitud"),
    @NamedQuery(name = "Pais.findByIndicativo", query = "SELECT p FROM Pais p WHERE p.indicativo = :indicativo"),
    @NamedQuery(name = "Pais.findByEstadoPais", query = "SELECT p FROM Pais p WHERE p.estadoPais = :estadoPais ORDER BY P.nombrePais")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pais")
    private Integer idPais;
    @Size(max = 10)
    @Column(name = "cod_pais_dane")
    private String codPaisDane;
    @Size(max = 70)
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Size(max = 10)
    @Column(name = "cod_iso")
    private String codIso;
    @Size(max = 2147483647)
    @Column(name = "longitud")
    private String longitud;
    @Size(max = 2147483647)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 10)
    @Column(name = "indicativo")
    private String indicativo;
    @Column(name = "estado_pais")
    private Boolean estadoPais;
    @OneToMany(mappedBy = "idPais")
    private Collection<Departamento> departamentoCollection;

    public Pais() {
    }

    public Pais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getCodPaisDane() {
        return codPaisDane;
    }

    public void setCodPaisDane(String codPaisDane) {
        this.codPaisDane = codPaisDane;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCodIso() {
        return codIso;
    }

    public void setCodIso(String codIso) {
        this.codIso = codIso;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    public Boolean getEstadoPais() {
        return estadoPais;
    }

    public void setEstadoPais(Boolean estadoPais) {
        this.estadoPais = estadoPais;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.besports.entity.Pais[ idPais=" + idPais + " ]";
    }
    
}
