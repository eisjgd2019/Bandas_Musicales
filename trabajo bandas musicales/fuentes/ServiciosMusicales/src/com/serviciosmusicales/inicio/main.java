/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.inicio;

import com.serviciosmusicales.dao.GeneromusicalDaoImpl;
import com.serviciosmusicales.entity.Generomusical;
import com.serviciosmusicales.entity.Instrumento;
import com.serviciosmusicales.entity.Musico;
import com.serviciosmusicales.entity.Serviciocomplementario;
import com.serviciosmusicales.entity.Usuario;
import com.serviciosmusicales.facade.GeneromusicalFacade;
import com.serviciosmusicales.facade.GeneromusicalFacadeImpl;
import com.serviciosmusicales.facade.ServicioComplementarioFacade;
import com.serviciosmusicales.facade.ServicioComplementarioFacadeImpl;
import com.serviciosmusicales.facade.UsuarioFacade;
import com.serviciosmusicales.facade.UsuarioFacadeImpl;
import com.serviciosmusicales.singleton.SesionUsuario;
import com.serviciosmusicales.singleton.SesionUsuarioSingleton;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Hogar
 */
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SesionUsuario sesionUsuario = new SesionUsuario();
        Integer opc = null;
        Generomusical generoSeleccionado = null;
        int i= 0, iTemp = 0, cantMusicos = 0;
        // *** VAMOS A CONSTRUIR UN INICIO DE SESION UTILIZANDO EL PATRON DE DISEÑO SINGLETON
        System.out.println("********* BIENVENIDO A SUS SISTEMA DE GESTION DE SERVICIOS MUSICALES ***********");
        System.out.println("Iniciar Sesion...");
        System.out.println("usuario: ");
        sesionUsuario.setUsuario(sc.nextLine());
        System.out.println("Password: ");
        sesionUsuario.setClave(sc.nextLine());
        if (sesionUsuario != null) {
            UsuarioFacade facade = new UsuarioFacadeImpl();
            Usuario validaLogin = facade.validaLogin(sesionUsuario);
            if (validaLogin != null) {
                SesionUsuarioSingleton singleton = SesionUsuarioSingleton.getInstance();
                singleton.setSesionUsuario(sesionUsuario);

                System.out.println("***********************************************");
                System.out.println("* Bienvenido : " + validaLogin.getIdpersona().getNombreCompleto());
                System.out.println("***********************************************");

                System.out.println("+------------------------+");
                System.out.println("|     MENU PRINCIPAL     |");
                System.out.println("+------------------------+");

                // *** consultar generos existentes en la base de datos
                GeneromusicalFacade facadeGeneros = new GeneromusicalFacadeImpl();
                
                Collection<Generomusical> generosExistentes = facadeGeneros.consultarGenerosMusicales();
                for (Generomusical generoExistente : generosExistentes) {
                    System.out.println("[" + generoExistente.getCodigo() + "] "+ generoExistente.getNombre());
                }
                System.out.println("Seleccione el grupo musical de su interes : ");
                opc = sc.nextInt();
                // *** mostrar los instrumentos
                for (Generomusical generosExistente : generosExistentes) {
                    if (generosExistente.getCodigo().equals(opc)) {
                        generoSeleccionado = generosExistente;
                    }
                }
                System.out.println("Genero Seleccionado --> " + generoSeleccionado.getNombre() + ":");
                System.out.println("Sus instrumentos son: ");
                
                String instrumentoTemp = "";
                for (Instrumento instrumento : generoSeleccionado.getInstrumentoCollection()) {
                    instrumentoTemp = instrumento.getInstrumento();
                    for (Musico musico : instrumento.getMusicoCollection()) {
                        if (musico.getEstado().equals(1)) {
                            iTemp++;
                            cantMusicos++;
                        } 
                    }
                    i = iTemp;
                    
                    iTemp=0; 
                    System.out.println(instrumentoTemp + " - " + "Musicos Disponibles : " + i);
                }
                
                if (generoSeleccionado.getInstrumentoCollection().size() != cantMusicos) {
                    System.out.println("La banda no esta disponibles para la fecha seleccionada");
                } else {
                    System.out.println("¡¡¡ Musicos Disponibles !!!");
                    System.out.println("Desea continuar con su solicitud de servicio ? digite [1] para continuar, [0] pasar salir. ");
                    opc = sc.nextInt();
                    if (opc.equals(1)) {
                        System.out.println("Desea contratar nuestros servicios adicionales : ");
                        // *** consultar los servicios adicionales
                    } else {
                        System.out.println("Gracias por visitarnos, hasta pronto. Servicios musicales.");
                        System.out.println("Servicios Musicales.");
                    }
                    // *** mostrar servicios complementarios
                    ServicioComplementarioFacade complementarioFacade = new ServicioComplementarioFacadeImpl();
                    Collection<Serviciocomplementario> serviciosComplementarios = complementarioFacade.obtenerServiciosComplementarios();
                    for (Serviciocomplementario servicioComplementario : serviciosComplementarios) {
                        System.out.println("[" + servicioComplementario.getIdComple() + "] : " + servicioComplementario.getDescripcion());
                    }
                }
            } else {
                System.out.println("Usuario no registrado contacte al administrador para su registro en el sistema.");
            }
        }
    }
}
