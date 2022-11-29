/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HerneyGil
 */
@Entity
@Table(name = "valor_configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorConfiguracion.findAll", query = "SELECT v FROM ValorConfiguracion v"),
    @NamedQuery(name = "ValorConfiguracion.findByIdValorConf", query = "SELECT v FROM ValorConfiguracion v WHERE v.idValorConf = :idValorConf"),
    @NamedQuery(name = "ValorConfiguracion.findByIdValorConfi", query = "SELECT v FROM ValorConfiguracion v WHERE v.valorConfiguracion = :valor  AND v.estado = :estado ORDER BY v.descripcion"),
    @NamedQuery(name = "ValorConfiguracion.findByValorConfiguracion", query = "SELECT v FROM ValorConfiguracion v WHERE v.valorConfiguracion = :valorConfiguracion"),
    @NamedQuery(name = "ValorConfiguracion.findByDescripcion", query = "SELECT v FROM ValorConfiguracion v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "ValorConfiguracion.findByTipoConf", query = "SELECT v FROM ValorConfiguracion v WHERE v.idTipoConf.nombreConfiguracion = :nombrecf AND v.estado = :estado"),
    @NamedQuery(name = "ValorConfiguracion.findByEstado", query = "SELECT v FROM ValorConfiguracion v WHERE v.estado = :estado")})
public class ValorConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valor_conf")
    private Integer idValorConf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "valor_configuracion")
    private String valorConfiguracion;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "id_tipo_conf", referencedColumnName = "id_configuracion")
    @ManyToOne
    private TipoConfiguracion idTipoConf;

    public ValorConfiguracion() {
    }

    public ValorConfiguracion(Integer idValorConf) {
        this.idValorConf = idValorConf;
    }

    public ValorConfiguracion(Integer idValorConf, String valorConfiguracion) {
        this.idValorConf = idValorConf;
        this.valorConfiguracion = valorConfiguracion;
    }

    public Integer getIdValorConf() {
        return idValorConf;
    }

    public void setIdValorConf(Integer idValorConf) {
        this.idValorConf = idValorConf;
    }

    public String getValorConfiguracion() {
        return valorConfiguracion;
    }

    public void setValorConfiguracion(String valorConfiguracion) {
        this.valorConfiguracion = valorConfiguracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoConfiguracion getIdTipoConf() {
        return idTipoConf;
    }

    public void setIdTipoConf(TipoConfiguracion idTipoConf) {
        this.idTipoConf = idTipoConf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorConf != null ? idValorConf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorConfiguracion)) {
            return false;
        }
        ValorConfiguracion other = (ValorConfiguracion) object;
        if ((this.idValorConf == null && other.idValorConf != null) || (this.idValorConf != null && !this.idValorConf.equals(other.idValorConf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.besports.entity.ValorConfiguracion[ idValorConf=" + idValorConf + " ]";
    }

}
