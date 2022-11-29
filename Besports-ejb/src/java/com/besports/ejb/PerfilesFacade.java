/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Perfiles;
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
public class PerfilesFacade extends AbstractFacade<Perfiles> implements PerfilesFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Perfiles> findByEstado() {

        TypedQuery<Perfiles> queryProductsByName = this.em.createNamedQuery("Perfiles.findByEstado", Perfiles.class);
        queryProductsByName.setParameter("estado", true);
        List<Perfiles> perfil = queryProductsByName.getResultList();

//        List<VwDepartamentos> listWithoutDuplicates = departamento.stream().distinct().collect(Collectors.toList());
        return perfil;
    }

    public PerfilesFacade() {
        super(Perfiles.class);
    }

}
