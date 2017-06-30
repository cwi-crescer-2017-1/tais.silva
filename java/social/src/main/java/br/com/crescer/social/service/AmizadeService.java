/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Amizade;
import br.com.crescer.social.repositorio.AmizadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class AmizadeService {

    @Autowired
    AmizadeRepositorio amizadeRepositorio;   
    
    public Amizade save(Amizade t) {
      return amizadeRepositorio.save(t);
    }
    
    public void remove(Amizade t) {
      amizadeRepositorio.delete(t);
    }
    
    public Amizade loadById(Long id) {
      return amizadeRepositorio.findOne(id);
    }
    
    public Iterable<Amizade> findAll() {
      return amizadeRepositorio.findAll();
    }
}
