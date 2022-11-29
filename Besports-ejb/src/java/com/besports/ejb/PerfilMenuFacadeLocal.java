/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.PerfilMenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HerneyGil
 */
@Local
public interface PerfilMenuFacadeLocal {

    void create(PerfilMenu perfilMenu);

    void edit(PerfilMenu perfilMenu);

    void remove(PerfilMenu perfilMenu);

    PerfilMenu find(Object id);

    List<PerfilMenu> findAll();

    List<PerfilMenu> findRange(int[] range);

    int count();

    public List<PerfilMenu> findByPerfil(Object idPerfil);
    
}
