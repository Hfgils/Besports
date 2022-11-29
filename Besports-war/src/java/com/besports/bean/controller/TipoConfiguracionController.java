/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;

import com.besports.ejb.TipoConfiguracionFacadeLocal;
import com.besports.entity.TipoConfiguracion;
import com.besports.entity.ValorConfiguracion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author hgil
 */
@Named(value = "tipoConfiguracionController")
@SessionScoped
public class TipoConfiguracionController implements Serializable {

    @EJB
    private TipoConfiguracionFacadeLocal tipoConfEJB;
    @Inject
    private TipoConfiguracion tipoConfiguracion;

    public List<TipoConfiguracion> getAllValo() {
        return this.tipoConfEJB.findAll();
    }

    public void add() {
        this.tipoConfEJB.create(tipoConfiguracion);
        reset();
    }

    public void reset() {
        this.tipoConfiguracion.setIdConfiguracion(null);
        this.tipoConfiguracion.setNombreConfiguracion(null);
        this.tipoConfiguracion.setEstado(false);
        this.tipoConfiguracion.setDetalleConfiguracion(null);

    }

    /**
     * Creates a new instance of TipoConfiguracionController
     */
    public TipoConfiguracionController() {
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

}
