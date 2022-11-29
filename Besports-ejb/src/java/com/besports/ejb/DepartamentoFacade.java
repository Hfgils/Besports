/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author HerneyGil
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Departamento> findByDepartamentoPais(Integer pais) {

        TypedQuery<Departamento> queryProductsByName = this.em.createNamedQuery("Departamento.findByPais", Departamento.class);
        queryProductsByName.setParameter("estado", true);
        queryProductsByName.setParameter("idPais", pais);
        List<Departamento> departamento = queryProductsByName.getResultList();

//        List<Departamento> listWithoutDuplicates = departamento.stream().distinct().collect(Collectors.toList());
        return departamento;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

}
