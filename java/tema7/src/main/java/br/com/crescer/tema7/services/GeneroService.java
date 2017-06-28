/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.services;

import br.com.crescer.tema7.entidades.Genero;
import br.com.crescer.tema7.repositorios.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class GeneroService {

    @Autowired
    GeneroRepositorio generoRepositorio;  
    
    public Genero save(Genero t) {
      return generoRepositorio.save(t);
    }
    
    public void remove(Genero t) {
      generoRepositorio.delete(t);
    }
    
    public Genero loadById(Long id) {
      return generoRepositorio.findOne(id);
    }
    
    public Iterable<Genero> findAll() {
      return generoRepositorio.findAll();
    }
}
