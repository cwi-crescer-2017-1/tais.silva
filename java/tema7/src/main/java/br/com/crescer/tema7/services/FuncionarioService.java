/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.services;

import br.com.crescer.tema7.entidades.Funcionario;
import br.com.crescer.tema7.repositorios.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepositorio funcionarioRepositorio;  
    
    public Funcionario save(Funcionario t) {
      return funcionarioRepositorio.save(t);
    }
    
    public void remove(Funcionario t) {
      funcionarioRepositorio.delete(t);
    }
    
    public Funcionario loadById(Long id) {
      return funcionarioRepositorio.findOne(id);
    }
    
    public Iterable<Funcionario> findAll() {
      return funcionarioRepositorio.findAll();
    }
}
