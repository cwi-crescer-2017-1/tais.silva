/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Reacao;
import br.com.crescer.social.repositorio.ReacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class ReacaoService {

    @Autowired
    ReacaoRepositorio reacaoRepositorio;   
    
    public Reacao save(Reacao t) {
      return reacaoRepositorio.save(t);
    }
    
    public void remove(Reacao t) {
      reacaoRepositorio.delete(t);
    }
    
    public Reacao loadById(Long id) {
      return reacaoRepositorio.findOne(id);
    }
    
    public Iterable<Reacao> findAll() {
      return reacaoRepositorio.findAll();
    }
}
