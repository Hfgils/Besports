/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.ValorConfiguracion;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HerneyGil
 */
@Local
public interface ValorConfiguracionFacadeLocal {

    void create(ValorConfiguracion valorConfiguracion);

    void edit(ValorConfiguracion valorConfiguracion);

    void remove(ValorConfiguracion valorConfiguracion);

    ValorConfiguracion find(Object id);

    List<ValorConfiguracion> findAll();

    List<ValorConfiguracion> findRange(int[] range);

    int count();



    public List<ValorConfiguracion> findByTipoConf(String TipoConf, Character estado);


    public HashMap<String, String> findByldap(String TipoConf, Boolean estado);

    public List<ValorConfiguracion> findByValor(String TipoConf, Boolean estado);

    public List<ValorConfiguracion> findByTipoConf(String TipoConf);

    public List<ValorConfiguracion> findByTipoConf(String TipoConf, Boolean estado);
    
}
