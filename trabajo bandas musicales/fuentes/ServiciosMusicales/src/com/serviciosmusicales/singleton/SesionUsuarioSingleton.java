/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.singleton;

/**
 *
 * @author Hogar
 */
public class SesionUsuarioSingleton {
    
    private static SesionUsuarioSingleton sesionUnica;
    private SesionUsuario sesionUsuario;

    private SesionUsuarioSingleton() {
        sesionUsuario = new SesionUsuario("usuario", "clave");
    }
    
    public static SesionUsuarioSingleton getInstance() {
        if (sesionUnica == null) {
            sesionUnica = new SesionUsuarioSingleton();
        }
        return sesionUnica;
    }

    public SesionUsuario getSesionUsuario() {
        return sesionUsuario;
    }

    public void setSesionUsuario(SesionUsuario sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }
}
