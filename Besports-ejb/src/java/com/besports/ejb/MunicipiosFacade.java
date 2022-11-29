/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Municipios;
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
public class MunicipiosFacade extends AbstractFacade<Municipios> implements MunicipiosFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Municipios> findByMunicipioDisitnct(Integer idDepartamento) {
       
        TypedQuery<Municipios> queryProductsByName = this.em.createNamedQuery("Municipios.findByDepartamento", Municipios.class);
        queryProductsByName.setParameter("estado",true);
        queryProductsByName.setParameter("idDepartamento", idDepartamento);
        List<Municipios>departamento = queryProductsByName.getResultList();

//        List<Municipios> listWithoutDuplicates = departamento.stream().distinct().collect(Collectors.toList());

        return departamento;
    }
    public MunicipiosFacade() {
        super(Municipios.class);
    }

}
