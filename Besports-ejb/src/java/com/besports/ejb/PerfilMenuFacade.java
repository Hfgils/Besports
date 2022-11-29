/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.PerfilMenu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author HerneyGil
 */
@Stateless
public class PerfilMenuFacade extends AbstractFacade<PerfilMenu> implements PerfilMenuFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    private List<PerfilMenu> PerfilMenu;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<PerfilMenu> findByPerfil(Object idPerfil) {
        try {
            TypedQuery<PerfilMenu> queryProductsByName = this.em.createNamedQuery("PerfilMenu.findByIdPerfil", PerfilMenu.class);
            queryProductsByName.setParameter("idPerfil", idPerfil);
            queryProductsByName.setParameter("estado", true);
            PerfilMenu = queryProductsByName.getResultList();
        } catch (Exception e) {
        } finally {
            Cache cache = em.getEntityManagerFactory().getCache();
            cache.evictAll();
        }

        return PerfilMenu;

    }

    public PerfilMenuFacade() {
        super(PerfilMenu.class);
    }

}
