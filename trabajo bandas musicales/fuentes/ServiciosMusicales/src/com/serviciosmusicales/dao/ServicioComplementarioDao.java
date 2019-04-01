/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.dao;

import com.serviciosmusicales.entity.Serviciocomplementario;
import java.util.Collection;

/**
 *
 * @author Hogar
 */
public interface ServicioComplementarioDao {

    public Collection<Serviciocomplementario> listarServiciosComplementarios();
}
