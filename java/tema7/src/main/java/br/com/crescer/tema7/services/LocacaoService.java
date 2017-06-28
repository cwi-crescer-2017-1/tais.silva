/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.services;

import br.com.crescer.tema7.entidades.Locacao;
import br.com.crescer.tema7.repositorios.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepositorio locacaoRepositorio;  
    
    public Locacao save(Locacao t) {
      return locacaoRepositorio.save(t);
    }
    
    public void remove(Locacao t) {
      locacaoRepositorio.delete(t);
    }
    
    public Locacao loadById(Long id) {
      return locacaoRepositorio.findOne(id);
    }
    
    public Iterable<Locacao> findAll() {
      return locacaoRepositorio.findAll();
    }
}
