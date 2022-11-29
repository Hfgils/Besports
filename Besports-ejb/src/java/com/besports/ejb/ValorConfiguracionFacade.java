/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.ValorConfiguracion;
import java.util.HashMap;
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
public class ValorConfiguracionFacade extends AbstractFacade<ValorConfiguracion> implements ValorConfiguracionFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValorConfiguracionFacade() {
        super(ValorConfiguracion.class);
    }

    @Override
    public HashMap<String, String> findByldap(String TipoConf, Boolean estado) {
        TypedQuery<ValorConfiguracion> queryProductsByName = this.em.createNamedQuery("ValorConfiguracion.findByTipoConf", ValorConfiguracion.class);
        queryProductsByName.setParameter("nombrecf", TipoConf);
        queryProductsByName.setParameter("estado", estado);
        HashMap<String, String> DeHashMap = new HashMap<String, String>();
        List<ValorConfiguracion> list = queryProductsByName.getResultList();
        for (ValorConfiguracion result : list) {
            DeHashMap.put(result.getDescripcion(), result.getValorConfiguracion());
        }
        return DeHashMap;
    }

    @Override
    public List<ValorConfiguracion> findByTipoConf(String TipoConf, Boolean estado) {

        getEntityManager().flush();
        TypedQuery<ValorConfiguracion> queryProductsByName = this.em.createNamedQuery("ValorConfiguracion.findByTipoConf", ValorConfiguracion.class);
        queryProductsByName.setParameter("nombrecf", TipoConf);
        queryProductsByName.setParameter("estado", estado);
        return queryProductsByName.getResultList();
    }

    @Override
    public List<ValorConfiguracion> findByValor(String TipoConf, Boolean estado) {
        System.out.println(TipoConf);

        getEntityManager().flush();
        TypedQuery<ValorConfiguracion> queryProductsByName = this.em.createNamedQuery("ValorConfiguracion.findByValor", ValorConfiguracion.class);
        queryProductsByName.setParameter("valor", TipoConf);
        queryProductsByName.setParameter("estado", estado);
        return queryProductsByName.getResultList();
    }

    @Override
    public List<ValorConfiguracion> findByTipoConf(String TipoConf) {

        getEntityManager().flush();
        TypedQuery<ValorConfiguracion> queryProductsByName = this.em.createNamedQuery("ValorConfiguracion.findByTipoConf", ValorConfiguracion.class);
        queryProductsByName.setParameter("nombrecf", TipoConf);
        queryProductsByName.setParameter("estado", true);
        return queryProductsByName.getResultList();
    }

    @Override
    public List<ValorConfiguracion> findByTipoConf(String TipoConf, Character estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
