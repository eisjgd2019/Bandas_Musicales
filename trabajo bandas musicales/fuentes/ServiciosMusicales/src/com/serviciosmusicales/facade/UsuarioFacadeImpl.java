/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.facade;

import com.serviciosmusicales.dao.UsuarioDao;
import com.serviciosmusicales.dao.UsuarioDaoImpl;
import com.serviciosmusicales.entity.Usuario;
import com.serviciosmusicales.entity.UsuarioPK;
import com.serviciosmusicales.singleton.SesionUsuario;

/**
 *
 * @author Hogar
 */
public class UsuarioFacadeImpl implements  UsuarioFacade {
    
    private UsuarioDao usuarioDao = new UsuarioDaoImpl();
    
    @Override
    public Usuario validaLogin(SesionUsuario usuario) {
        Usuario usuario1 = new Usuario(new UsuarioPK(usuario.getUsuario(), usuario.getClave()));
        return usuarioDao.login(usuario1);
    }
    
}
