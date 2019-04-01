/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.dao;

import com.serviciosmusicales.entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hogar
 */
public class UsuarioDaoImpl implements UsuarioDao {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServiciosMusicalesPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = null;
        try {
            user = em.find(Usuario.class, usuario.getUsuarioPK());
        } catch (Exception e) {
            System.out.println("Error consultando la base de datos " + e);
        } finally {
            em.close();
        }
        return user;
    }

}
