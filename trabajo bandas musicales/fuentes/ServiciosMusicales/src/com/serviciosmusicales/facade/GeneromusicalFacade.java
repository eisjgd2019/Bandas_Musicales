/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosmusicales.facade;

import com.serviciosmusicales.entity.Generomusical;
import java.util.Collection;

/**
 *
 * @author Hogar
 */
public interface GeneromusicalFacade {
    
    public Collection<Generomusical> consultarGenerosMusicales();
    
}
