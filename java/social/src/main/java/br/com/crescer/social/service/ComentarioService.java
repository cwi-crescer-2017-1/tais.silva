/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Comentario;
import br.com.crescer.social.repositorio.ComentarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepositorio comentarioRepositorio;   
    
    public Comentario save(Comentario t) {
      return comentarioRepositorio.save(t);
    }
    
    public void remove(Comentario t) {
      comentarioRepositorio.delete(t);
    }
    
    public Comentario loadById(Long id) {
      return comentarioRepositorio.findOne(id);
    }
    
    public Iterable<Comentario> findAll() {
      return comentarioRepositorio.findAll();
    }
}
