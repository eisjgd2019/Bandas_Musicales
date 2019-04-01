/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.facade;

import com.serviciosmusicales.dao.GeneromusicalDao;
import com.serviciosmusicales.dao.GeneromusicalDaoImpl;
import com.serviciosmusicales.entity.Generomusical;
import java.util.Collection;

/**
 *
 * @author Hogar
 */
public class GeneromusicalFacadeImpl implements GeneromusicalFacade {
    
    private GeneromusicalDao generomusicalDao = new GeneromusicalDaoImpl();

    @Override
    public Collection<Generomusical> consultarGenerosMusicales() {
        return generomusicalDao.obtenerGenerosMusicales();
    }
    
}
