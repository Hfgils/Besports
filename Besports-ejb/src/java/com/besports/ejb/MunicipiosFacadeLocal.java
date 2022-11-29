/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Municipios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HerneyGil
 */
@Local
public interface MunicipiosFacadeLocal {

    void create(Municipios municipios);

    void edit(Municipios municipios);

    void remove(Municipios municipios);

    Municipios find(Object id);

    List<Municipios> findAll();

    List<Municipios> findRange(int[] range);

    int count();

    public List<Municipios> findByMunicipioDisitnct(Integer idDepartamento);
    
}
