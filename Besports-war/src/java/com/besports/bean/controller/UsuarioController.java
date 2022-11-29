/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;

import com.besports.ejb.MunicipiosFacadeLocal;
import com.besports.ejb.PaisFacadeLocal;
import com.besports.ejb.PerfilesFacadeLocal;
import com.besports.ejb.PersonasFacadeLocal;
import com.besports.ejb.UsuarioFacadeLocal;
import com.besports.ejb.ValorConfiguracionFacadeLocal;
import com.besports.ejb.DepartamentoFacadeLocal;
import com.besports.entity.Municipios;
import com.besports.entity.Pais;
import com.besports.entity.Perfiles;
import com.besports.entity.Personas;
import com.besports.entity.TipoConfiguracion;
import com.besports.entity.Usuario;
import com.besports.entity.ValorConfiguracion;
import com.besports.entity.Departamento;
import com.besports.util.Encrypt;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Herney
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private final Encrypt encrypt = new Encrypt();
    private final Encrypt dencrypt = new Encrypt();
    private String pass = null, pass1 = null;
    private String password;
    private boolean passMatch;
    private String emailRegexp = "@[^@]+\\.[a-zA-Z]{2,}";

    @Inject
    private Usuario usuario;
    @Inject
    private Personas personas;
    @Inject
    private TipoConfiguracion tipoConfiguracion;
    @Inject
    private ValorConfiguracion Tdocumento;
    @Inject
    private Pais paisnac;
    @Inject
    private Municipios municipionac;
    @Inject
    private Departamento departamentonac;
    @Inject
    private Pais paisexp;
    @Inject
    private Municipios municipioexp;
    @Inject
    private Municipios departamentoexp;
    @Inject
    private Perfiles perfil;

    @EJB
    private PerfilesFacadeLocal perfilEJB;
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PersonasFacadeLocal personaEJB;
    @EJB
    private ValorConfiguracionFacadeLocal tdocumentoEJB;
    @EJB
    private PaisFacadeLocal paisnacEJB;
    @EJB
    private MunicipiosFacadeLocal municipiosnacEJB;
    @EJB
    private DepartamentoFacadeLocal departamentosnacEJB;
    @EJB
    private PaisFacadeLocal paisexpEJB;
    @EJB
    private MunicipiosFacadeLocal municipiosexpEJB;
    @EJB
    private MunicipiosFacadeLocal departamentosexpEJB;

    private List<ValorConfiguracion> Tdocumentos;
    private List<Perfiles> perfiles;

    private List<Pais> paisnacs;
    private List<Municipios> municipiosnac;
    private List<Departamento> departamentosnac;
    private List<Pais> paisexps;
    private List<Municipios> municipioexps;
    private List<Municipios> departamentoexps;

    @PostConstruct
    public void init() {
        //this.Tdocumentos = tdocumentoEJB.findByTipoConf("TIPO DOCUMENTO");
        this.setPaisnacs(this.paisnacEJB.findByEstado());
        this.perfiles = perfilEJB.findByEstado();
    }

    @PreDestroy
    public void destroy() {
//        oS.getos();
        paisnacs.clear();
    }

    public void add() {
        System.out.println(usuario.getNombreUsuario().replace("@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]", ""));

        //  personas.setNombre(personas.getPrimerNombre() + " " + personas.getSegundoNombre() + " " + personas.getPrimerApellido() + " " + personas.getSegundoApellido());
        personaEJB.create(personas);

        usuario.setIdPersona(personaEJB.find(this.personaEJB.findByDocumento(this.personas.getDocumento()).get(0).getIdPersona()));
        usuario.setIdPerfil(perfilEJB.find(this.perfil.getIdPerfil()));

        if (usuario.getLdapLogin() == true) {
            usuario.setPassword(null);
        } else {
            usuario.setPassword(encrypt.encrypt(usuario.getPassword()));
        }
        usuario.setEstado(true);
        usuario.setNombreUsuario(usuario.getNombreUsuario().replaceAll(emailRegexp, ""));

        usuarioEJB.create(usuario);

        String identificacion = null;
//        addUser(identificacion);
        reset();
        FacesMessage msg = new FacesMessage("Registro Guardado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//    public void addUser(String identificacion) {
//
//        reset();
//        FacesMessage msg = new FacesMessage("Registro Guardado");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    public void reset() {
        this.departamentosnac.clear();
        this.municipiosnac.clear();

        //this.personas.setNombre(null);
        this.personas.setPrimerApellido(null);
        this.personas.setSegundoApellido(null);
        this.personas.setPrimerNombre(null);
        //this.personas.setNombre(null);
        this.personas.setPrimerApellido(null);
        this.personas.setFechaNacimiento(null);
        this.personas.setIdTipodocumento(0);
        this.personas.setDocumento(null);

        this.usuario.setPassword(null);
        this.usuario.setNombreUsuario(null);
        this.usuario.setIdPersona(null);
        this.usuario.setIdPerfil(null);
        this.usuario.setPassword(null);

    }

    public void paisnacChange() {
        if (this.paisnac.getIdPais() == null || this.paisnac.getIdPais().equals(Integer.valueOf(0))) {

            this.getDepartamentosnac().clear();
            this.municipiosnac.clear();
        } else if (this.paisnac.getIdPais() != null || !this.paisnac.getIdPais().equals(Integer.valueOf(0))) {
            System.out.println(this.paisnac.getIdPais());
            this.setDepartamentosnac(this.departamentosnacEJB.findByDepartamentoPais(this.paisnac.getIdPais()));
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Seleccione un dato"));
            FacesContext facesContext = FacesContext.getCurrentInstance();
        }
    }

    public void departamentonacChange() {
//        if (this.paisnac.getIdPais() == null || this.paisnac.getIdPais().equals(Integer.valueOf(0)) || this.departamentonac.getCodDaneDep() == null || this.departamentonac.getCodDaneDep().equals(Integer.valueOf(0))) {
//            System.out.println("a");
//            this.getDepartamentosnac().clear();
//            this.municipiosnac.clear();
//        } else if (this.departamentonac.getCodDaneDep() != null && !this.departamentonac.getCodDaneDep().equals(Integer.valueOf(0))) {
//            System.out.println(this.departamentonac.getCodDaneDep());
//            this.municipiosnac = this.municipiosnacEJB.findMunicipioByDepartamento(this.departamentonac.getCodDaneDep());
//        } else {
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Seleccione un dato"));
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//        }
    }

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the personas
     */
    public Personas getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    /**
     * @return the tipoConfiguracion
     */
    public TipoConfiguracion getTipoConfiguracion() {
        return tipoConfiguracion;
    }

    /**
     * @param tipoConfiguracion the tipoConfiguracion to set
     */
    public void setTipoConfiguracion(TipoConfiguracion tipoConfiguracion) {
        this.tipoConfiguracion = tipoConfiguracion;
    }

    /**
     * @return the Tdocumento
     */
    public ValorConfiguracion getTdocumento() {
        return Tdocumento;
    }

    /**
     * @param Tdocumento the Tdocumento to set
     */
    public void setTdocumento(ValorConfiguracion Tdocumento) {
        this.Tdocumento = Tdocumento;
    }

    /**
     * @return the Tdocumentos
     */
    public List<ValorConfiguracion> getTdocumentos() {
        return Tdocumentos;
    }

    /**
     * @param Tdocumentos the Tdocumentos to set
     */
    public void setTdocumentos(List<ValorConfiguracion> Tdocumentos) {
        this.Tdocumentos = Tdocumentos;
    }

    /**
     * @return the paisnac
     */
    public Pais getPaisnac() {
        return paisnac;
    }

    /**
     * @param paisnac the paisnac to set
     */
    public void setPaisnac(Pais paisnac) {
        this.paisnac = paisnac;
    }

    /**
     * @return the municipionac
     */
    public Municipios getMunicipionac() {
        return municipionac;
    }

    /**
     * @param municipionac the municipionac to set
     */
    public void setMunicipionac(Municipios municipionac) {
        this.municipionac = municipionac;
    }

    /**
     * @return the departamentonac
     */
    public Departamento getDepartamentonac() {
        return departamentonac;
    }

    /**
     * @param departamentonac the departamentonac to set
     */
    public void setDepartamentonac(Departamento departamentonac) {
        this.departamentonac = departamentonac;
    }

    /**
     * @return the paisexp
     */
    public Pais getPaisexp() {
        return paisexp;
    }

    /**
     * @param paisexp the paisexp to set
     */
    public void setPaisexp(Pais paisexp) {
        this.paisexp = paisexp;
    }

    /**
     * @return the municipioexp
     */
    public Municipios getMunicipioexp() {
        return municipioexp;
    }

    /**
     * @param municipioexp the municipioexp to set
     */
    public void setMunicipioexp(Municipios municipioexp) {
        this.municipioexp = municipioexp;
    }

    /**
     * @return the departamentoexp
     */
    public Municipios getDepartamentoexp() {
        return departamentoexp;
    }

    /**
     * @param departamentoexp the departamentoexp to set
     */
    public void setDepartamentoexp(Municipios departamentoexp) {
        this.departamentoexp = departamentoexp;
    }

    /**
     * @return the paisnacs
     */
    public List<Pais> getPaisnacs() {
        return paisnacs;
    }

    /**
     * @param paisnacs the paisnacs to set
     */
    public void setPaisnacs(List<Pais> paisnacs) {
        this.paisnacs = paisnacs;
    }

    /**
     * @return the municipiosnac
     */
    public List<Municipios> getMunicipiosnac() {
        return municipiosnac;
    }

    /**
     * @param municipiosnac the municipiosnac to set
     */
    public void setMunicipiosnac(List<Municipios> municipiosnac) {
        this.municipiosnac = municipiosnac;
    }

    /**
     * @return the departamentosnac
     */
    public List<Departamento> getDepartamentosnac() {
        return departamentosnac;
    }

    /**
     * @param departamentosnac the departamentosnac to set
     */
    public void setDepartamentosnac(List<Departamento> departamentosnac) {
        this.departamentosnac = departamentosnac;
    }

    /**
     * @return the perfiles
     */
    public List<Perfiles> getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(List<Perfiles> perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the perfil
     */
    public Perfiles getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfiles perfil) {
        this.perfil = perfil;
    }

}
