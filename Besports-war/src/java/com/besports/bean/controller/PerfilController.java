/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.besports.bean.controller;

import com.besports.ejb.EmpresaFacadeLocal;
import com.besports.ejb.MenuFacadeLocal;
import com.besports.ejb.PerfilesFacadeLocal;
import com.besports.entity.Empresa;
import com.besports.entity.Menu;
import com.besports.entity.PerfilMenu;
import com.besports.entity.Perfiles;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author HerneyGil
 */
@Named(value = "perfilController")
@SessionScoped
public class PerfilController implements Serializable {

    @EJB
    private PerfilesFacadeLocal perfilEJB;
    @EJB
    private EmpresaFacadeLocal empresaEJB;

    @Inject
    private Perfiles perfil;
    @Inject
    private Empresa empresa;

    private List<Perfiles> perfiles;
    private List<Empresa> empresas;

    @PostConstruct
    public void init() {

        this.setPerfiles(this.perfilEJB.findAll());
        this.setEmpresas(empresaEJB.findAll());

    }

    public void add() {
        // perfil.setIdEmpresa(empresaEJB.find(this.personaEJB.findByDocumento(this.personas.getDocumento()).get(0).getIdPersona()));
        perfilEJB.create(perfil);
        reset();
    }

    public void reset() {
        this.perfil.setIdPerfil(null);
        this.perfil.setNombrePerfil(null);
        this.perfil.setDetallePerfil(null);
        this.perfil.setIdEmpresa(null);
        this.perfil.setEstado(Boolean.FALSE);
    }

    /**
     * Creates a new instance of PerfilController
     */
    public PerfilController() {
    }

    /**
     * @return the perfil
     */
    public Perfiles getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfilMenu to set
     */
    public void setPerfil(Perfiles perfil) {
        this.perfil = perfil;
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
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the empresas
     */
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    /**
     * @param empresas the empresas to set
     */
    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
