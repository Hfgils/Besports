/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Departamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HerneyGil
 */
@Local
public interface DepartamentoFacadeLocal {

    void create(Departamento departamento);

    void edit(Departamento departamento);

    void remove(Departamento departamento);

    Departamento find(Object id);

    List<Departamento> findAll();

    List<Departamento> findRange(int[] range);

    int count();

    public List<Departamento> findByDepartamentoPais(Integer pais);
    
}
