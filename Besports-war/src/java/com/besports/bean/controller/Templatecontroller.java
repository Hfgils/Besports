/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;


import com.besports.entity.Usuario;
import java.io.Serializable;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author herney
 */
@Named(value = "templatecontroller")
@ViewScoped
public class Templatecontroller implements Serializable {

    private FacesContext context = FacesContext.getCurrentInstance();
    private NavigationHandler navigator = context.getApplication().getNavigationHandler();
    String contextName = context.getExternalContext().getContextName();

    public void sessionvalidate() {
        try {

            Usuario usuarios = (Usuario) context.getExternalContext().getSessionMap().get("Usuario");
            if (usuarios == null) {

                navigator.handleNavigation(context, null, "/resources/error/access-denied?faces-redirect=true");
 //               this.redireccion = "/resources/error/access-denied?faces-redirect=true";
//                context.getExternalContext().dispatch(contextName + "/404");
//                context.getExternalContext().redirect("./../../accessdenied.php");
            }

        } catch (Exception e) {
        }

    }

    /**
     * Creates a new instance of Templatecontroller
     */
    public Templatecontroller() {
    }

}
