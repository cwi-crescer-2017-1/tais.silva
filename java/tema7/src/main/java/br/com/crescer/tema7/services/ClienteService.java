/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.services;

import br.com.crescer.tema7.entidades.Cliente;
import br.com.crescer.tema7.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class ClienteService {

    @Autowired
    ClienteRepositorio clienteRepositorio;  
    
    public Cliente save(Cliente t) {
      return clienteRepositorio.save(t);
    }
    
    public void remove(Cliente t) {
      clienteRepositorio.delete(t);
    }
    
    public Cliente loadById(Long id) {
      return clienteRepositorio.findOne(id);
    }
    
    public Iterable<Cliente> findAll() {
      return clienteRepositorio.findAll();
    }
}
