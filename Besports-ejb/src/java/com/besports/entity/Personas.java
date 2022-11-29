/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HerneyGil
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Personas.findByIdTipodocumento", query = "SELECT p FROM Personas p WHERE p.idTipodocumento = :idTipodocumento"),
    @NamedQuery(name = "Personas.findByDocumento", query = "SELECT p FROM Personas p WHERE p.documento = :documento"),
    @NamedQuery(name = "Personas.findByDv", query = "SELECT p FROM Personas p WHERE p.dv = :dv"),
    @NamedQuery(name = "Personas.findByPrimerNombre", query = "SELECT p FROM Personas p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Personas.findBySegundoNombre", query = "SELECT p FROM Personas p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Personas.findByPrimerApellido", query = "SELECT p FROM Personas p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Personas.findBySegundoApellido", query = "SELECT p FROM Personas p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Personas.findByFechaNacimiento", query = "SELECT p FROM Personas p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Personas.findByCiudadNacimiento", query = "SELECT p FROM Personas p WHERE p.ciudadNacimiento = :ciudadNacimiento"),
    @NamedQuery(name = "Personas.findByFechaExpDoc", query = "SELECT p FROM Personas p WHERE p.fechaExpDoc = :fechaExpDoc"),
    @NamedQuery(name = "Personas.findByCiudadExpDoc", query = "SELECT p FROM Personas p WHERE p.ciudadExpDoc = :ciudadExpDoc"),
    @NamedQuery(name = "Personas.findByGenero", query = "SELECT p FROM Personas p WHERE p.genero = :genero"),
    @NamedQuery(name = "Personas.findByTipoSanguineo", query = "SELECT p FROM Personas p WHERE p.tipoSanguineo = :tipoSanguineo")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipodocumento")
    private int idTipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documento")
    private String documento;
    @Size(max = 8)
    @Column(name = "dv")
    private String dv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private Integer segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciudad_nacimiento")
    private int ciudadNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_exp_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaExpDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciudad_exp_doc")
    private int ciudadExpDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private int genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_sanguineo")
    private int tipoSanguineo;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Usuario> usuarioCollection;

    public Personas() {
    }

    public Personas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Personas(Integer idPersona, int idTipodocumento, String documento, String primerNombre, String primerApellido, Date fechaNacimiento, int ciudadNacimiento, Date fechaExpDoc, int ciudadExpDoc, int genero, int tipoSanguineo) {
        this.idPersona = idPersona;
        this.idTipodocumento = idTipodocumento;
        this.documento = documento;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.fechaExpDoc = fechaExpDoc;
        this.ciudadExpDoc = ciudadExpDoc;
        this.genero = genero;
        this.tipoSanguineo = tipoSanguineo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(int idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public Integer getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(Integer segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(int ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public Date getFechaExpDoc() {
        return fechaExpDoc;
    }

    public void setFechaExpDoc(Date fechaExpDoc) {
        this.fechaExpDoc = fechaExpDoc;
    }

    public int getCiudadExpDoc() {
        return ciudadExpDoc;
    }

    public void setCiudadExpDoc(int ciudadExpDoc) {
        this.ciudadExpDoc = ciudadExpDoc;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(int tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.besports.entity.Personas[ idPersona=" + idPersona + " ]";
    }
    
}
