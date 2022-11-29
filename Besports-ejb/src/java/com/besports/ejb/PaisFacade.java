/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Pais;
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
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Pais> findByEstado() {
        TypedQuery<Pais> queryProductsByName = this.em.createNamedQuery("Pais.findByEstadoPais", Pais.class);
        queryProductsByName.setParameter("estadoPais", true);
        List<Pais> SeoPais = queryProductsByName.getResultList();

        return SeoPais;
    }

    public PaisFacade() {
        super(Pais.class);
    }

}
