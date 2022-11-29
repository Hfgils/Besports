/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Personas;
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
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public List<Personas> findByDocumento(String identificacion) {

        TypedQuery<Personas> queryProductsByName = this.em.createNamedQuery("Personas.findByIdentificacion", Personas.class);
        queryProductsByName.setParameter("identificacion", identificacion);
        List<Personas> persona = queryProductsByName.getResultList();

//        List<VwDepartamentos> listWithoutDuplicates = departamento.stream().distinct().collect(Collectors.toList());
        return persona;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
}
