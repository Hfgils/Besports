/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;

import com.besports.ejb.TipoConfiguracionFacadeLocal;
import com.besports.ejb.ValorConfiguracionFacadeLocal;
import com.besports.entity.TipoConfiguracion;
import com.besports.entity.ValorConfiguracion;
import com.besports.util.Encrypt;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author hgil
 */
@Named(value = "valorConfController")
@SessionScoped
public class ValorConfController implements Serializable {

    @EJB
    private TipoConfiguracionFacadeLocal tipoConfEJB;
    @EJB
    private ValorConfiguracionFacadeLocal valorConfEJB;

    @Inject
    private TipoConfiguracion tipoConfiguracion;
    @Inject
    private ValorConfiguracion valorConfiguracion;

    private List<TipoConfiguracion> tipoConfiguracions;

    @PostConstruct
    public void init() {
        this.tipoConfiguracions = this.tipoConfEJB.findAll();
    }

    public List<ValorConfiguracion> getAllValo() {
        return this.valorConfEJB.findAll();
    }

    public void add() {
        System.out.println(this.tipoConfiguracion.getIdConfiguracion());
//        tipoConfEJB.find(this.tipoConfiguracion.getId());
        this.valorConfiguracion.setIdTipoConf(tipoConfEJB.find(this.tipoConfiguracion.getIdConfiguracion()));
        if (this.valorConfiguracion.getDescripcion().equals("PASSWORD")) {
            this.valorConfiguracion.setValorConfiguracion(Encrypt.encrypt(valorConfiguracion.getValorConfiguracion()));
        } else {
            this.valorConfiguracion.setValorConfiguracion(valorConfiguracion.getValorConfiguracion());
        }

        this.valorConfEJB.create(valorConfiguracion);

        System.out.println(valorConfiguracion.getValorConfiguracion());
        System.out.println(valorConfiguracion.getIdTipoConf());
        reset();
    }
//
    public void reset() {
//        this.valorConfiguracion.setId(null);
//        this.valorConfiguracion.setIdTipoConf(null);
//        this.valorConfiguracion.setValor(null);
//        this.valorConfiguracion.setNombre(null);
//        this.valorConfiguracion.setEstado(null);

    }
    /**
     * Creates a new instance of ValorConfiguracionController
     */
    public ValorConfController() {
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
     * @return the valorConfiguracion
     */
    public ValorConfiguracion getValorConfiguracion() {
        return valorConfiguracion;
    }

    /**
     * @param valorConfiguracion the valorConfiguracion to set
     */
    public void setValorConfiguracion(ValorConfiguracion valorConfiguracion) {
        this.valorConfiguracion = valorConfiguracion;
    }

    /**
     * @return the tipoConfiguracions
     */
    public List<TipoConfiguracion> getTipoConfiguracions() {
        return tipoConfiguracions;
    }

    /**
     * @param tipoConfiguracions the tipoConfiguracions to set
     */
    public void setTipoConfiguracions(List<TipoConfiguracion> tipoConfiguracions) {
        this.tipoConfiguracions = tipoConfiguracions;
    }
}
