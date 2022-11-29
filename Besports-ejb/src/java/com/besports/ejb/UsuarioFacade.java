/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.besports.ejb;

import com.besports.entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Besports-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Usuario> findByUsername(String username) {
        TypedQuery<Usuario> queryProductsByName = this.em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class);
        queryProductsByName.setParameter("nombreUsuario", username);
        List<Usuario> Usuarios = queryProductsByName.getResultList();

        return Usuarios;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
