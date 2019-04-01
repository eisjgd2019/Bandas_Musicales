/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.dao;

import com.serviciosmusicales.entity.Serviciocomplementario;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hogar
 */
public class ServicioComplementarioDaoImpl implements ServicioComplementarioDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServiciosMusicalesPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public Collection<Serviciocomplementario> listarServiciosComplementarios() {
        Collection<Serviciocomplementario> lista = null;
        try {
            lista = em.createNamedQuery("Serviciocomplementario.findAll").getResultList();
        } catch (Exception e) {
            System.out.println("Error consultando servicios complementarios " + e);
        } finally {
            em.close();
        }
        return lista;
    }

}
