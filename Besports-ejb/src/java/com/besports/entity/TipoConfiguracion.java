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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HerneyGil
 */
@Entity
@Table(name = "tipo_configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoConfiguracion.findAll", query = "SELECT t FROM TipoConfiguracion t"),
    @NamedQuery(name = "TipoConfiguracion.findByIdConfiguracion", query = "SELECT t FROM TipoConfiguracion t WHERE t.idConfiguracion = :idConfiguracion"),
    @NamedQuery(name = "TipoConfiguracion.findByNombreConfiguracion", query = "SELECT t FROM TipoConfiguracion t WHERE t.nombreConfiguracion = :nombreConfiguracion"),
    @NamedQuery(name = "TipoConfiguracion.findByDetalleConfiguracion", query = "SELECT t FROM TipoConfiguracion t WHERE t.detalleConfiguracion = :detalleConfiguracion"),
    @NamedQuery(name = "TipoConfiguracion.findByEstado", query = "SELECT t FROM TipoConfiguracion t WHERE t.estado = :estado")})
public class TipoConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_configuracion")
    private Integer idConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_configuracion")
    private String nombreConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "detalle_configuracion")
    private String detalleConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy = "idTipoConf")
    private Collection<ValorConfiguracion> valorConfiguracionCollection;

    public TipoConfiguracion() {
    }

    public TipoConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public TipoConfiguracion(Integer idConfiguracion, String nombreConfiguracion, String detalleConfiguracion, boolean estado) {
        this.idConfiguracion = idConfiguracion;
        this.nombreConfiguracion = nombreConfiguracion;
        this.detalleConfiguracion = detalleConfiguracion;
        this.estado = estado;
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getNombreConfiguracion() {
        return nombreConfiguracion;
    }

    public void setNombreConfiguracion(String nombreConfiguracion) {
        this.nombreConfiguracion = nombreConfiguracion;
    }

    public String getDetalleConfiguracion() {
        return detalleConfiguracion;
    }

    public void setDetalleConfiguracion(String detalleConfiguracion) {
        this.detalleConfiguracion = detalleConfiguracion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ValorConfiguracion> getValorConfiguracionCollection() {
        return valorConfiguracionCollection;
    }

    public void setValorConfiguracionCollection(Collection<ValorConfiguracion> valorConfiguracionCollection) {
        this.valorConfiguracionCollection = valorConfiguracionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracion != null ? idConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConfiguracion)) {
            return false;
        }
        TipoConfiguracion other = (TipoConfiguracion) object;
        if ((this.idConfiguracion == null && other.idConfiguracion != null) || (this.idConfiguracion != null && !this.idConfiguracion.equals(other.idConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.besports.entity.TipoConfiguracion[ idConfiguracion=" + idConfiguracion + " ]";
    }
    
}
