/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;

import com.besports.ejb.MenuFacadeLocal;
import com.besports.ejb.PerfilMenuFacadeLocal;
import com.besports.entity.Menu;
import com.besports.entity.PerfilMenu;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Herney
 */
@Named(value = "menuController")
@ViewScoped
public class MenuController implements Serializable {

    private FacesContext context = FacesContext.getCurrentInstance();

    private MenuModel model;

    @EJB
    private PerfilMenuFacadeLocal perfilmenuEJB;
    @EJB
    private MenuFacadeLocal menuEJB;

    @Inject
    private PerfilMenu perfilMenu;
    @Inject
    private Menu menu;

    private List<PerfilMenu> perfilMenus;
    private List<Menu> menus;
    private Map<String, Object> m = context.getExternalContext().getSessionMap();

    @PostConstruct
    public void init() {
        this.model = new DefaultMenuModel();
        this.setMenus(this.menuEJB.findAll());
        this.ListaMenus();
        RenderMenu();
    }

    public void ListaMenus() {
        try {
            System.out.println(this.m.get("Idperfil"));
            this.perfilMenus = this.perfilmenuEJB.findByPerfil(this.m.get("Idperfil"));
        } catch (Exception exception) {
        }
    }

    public void add() {
        menuEJB.create(menu);
        reset();
    }

    public void reset() {
        this.menu.setIdMenu(null);
        this.menu.setNombreMenu(null);
        this.menu.setMenuRuta(null);
        this.menu.setIconoMenu(null);
        this.menu.setMenuPadre(null);
        this.menu.setNivelMenu(null);
        this.menu.setEstado(Boolean.FALSE);
    }

    public void RenderMenu() {
        for (PerfilMenu Menu1 : perfilMenus) {

            if (Menu1.getIdMenu().getMenuPadre() == null && Menu1.getIdMenu().getNivelMenu() == null) {
                DefaultMenuItem item = DefaultMenuItem.builder()
                        .value(Menu1.getIdMenu().getNombreMenu())
                        .outcome(Menu1.getIdMenu().getMenuRuta())
                        .icon(Menu1.getIdMenu().getIconoMenu())
                        .build();
                model.getElements().add(item);
            } else if (Menu1.getIdMenu().getMenuPadre() == null && Menu1.getIdMenu().getNivelMenu().equals("S")) {
                DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                        .label(Menu1.getIdMenu().getNombreMenu())
                        .icon(Menu1.getIdMenu().getIconoMenu())
                        .build();
                for (PerfilMenu sMenu : perfilMenus) {
                    Menu submenu = sMenu.getIdMenu().getMenuPadre();
                    if (submenu != null) {
                        if (Objects.equals(submenu.getIdMenu(), Menu1.getIdMenu().getIdMenu())) {
                            DefaultMenuItem item = DefaultMenuItem.builder()
                                    .value(sMenu.getIdMenu().getNombreMenu())
                                    .outcome(sMenu.getIdMenu().getMenuRuta())
                                    .icon(sMenu.getIdMenu().getIconoMenu())
                                    .build();

                            firstSubmenu.getElements().add(item);
                        }
                    }
                }

                model.getElements().add(firstSubmenu);
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(MenuModel model) {
        this.model = model;
    }

    /**
     * @return the perfilMenu
     */
    public PerfilMenu getPerfilMenu() {
        return perfilMenu;
    }

    /**
     * @param perfilMenu the perfilMenu to set
     */
    public void setPerfilMenu(PerfilMenu perfilMenu) {
        this.perfilMenu = perfilMenu;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @return the menus
     */
    public List<Menu> getMenus() {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
