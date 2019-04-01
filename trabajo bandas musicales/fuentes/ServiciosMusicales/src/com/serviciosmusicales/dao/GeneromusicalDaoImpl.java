/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.dao;

import com.serviciosmusicales.entity.Generomusical;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hogar
 */
public class GeneromusicalDaoImpl implements GeneromusicalDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServiciosMusicalesPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public Collection<Generomusical> obtenerGenerosMusicales() {
        Collection<Generomusical> lista = null;
        try {
            lista = em.createNamedQuery("Generomusical.findAll").getResultList();
        } catch (Exception e) {
            System.out.println("Error consultando generos musicales " + e);
        } finally {
            em.close();
        }
        return lista;
    }

}
