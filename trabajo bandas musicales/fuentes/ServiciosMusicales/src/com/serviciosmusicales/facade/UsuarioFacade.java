/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.facade;

import com.serviciosmusicales.entity.Usuario;
import com.serviciosmusicales.singleton.SesionUsuario;

/**
 *
 * @author Hogar
 */
public interface UsuarioFacade {
    public Usuario validaLogin(SesionUsuario usuario);
}
