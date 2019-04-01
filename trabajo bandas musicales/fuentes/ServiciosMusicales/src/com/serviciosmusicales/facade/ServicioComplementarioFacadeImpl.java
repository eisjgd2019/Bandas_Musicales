/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.facade;

import com.serviciosmusicales.dao.ServicioComplementarioDao;
import com.serviciosmusicales.dao.ServicioComplementarioDaoImpl;
import com.serviciosmusicales.entity.Serviciocomplementario;
import java.util.Collection;

/**
 *
 * @author Hogar
 */
public class ServicioComplementarioFacadeImpl implements ServicioComplementarioFacade {

    private ServicioComplementarioDao complementarioDao = new ServicioComplementarioDaoImpl();

    @Override
    public Collection<Serviciocomplementario> obtenerServiciosComplementarios() {
        return complementarioDao.listarServiciosComplementarios();
    }

}
