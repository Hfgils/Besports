/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.TipoConfiguracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HerneyGil
 */
@Local
public interface TipoConfiguracionFacadeLocal {

    void create(TipoConfiguracion tipoConfiguracion);

    void edit(TipoConfiguracion tipoConfiguracion);

    void remove(TipoConfiguracion tipoConfiguracion);

    TipoConfiguracion find(Object id);

    List<TipoConfiguracion> findAll();

    List<TipoConfiguracion> findRange(int[] range);

    int count();
    
}
