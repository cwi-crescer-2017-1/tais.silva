/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.controllers;

import br.com.crescer.tema7.entidades.Cliente;
import br.com.crescer.tema7.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tais.silva
 */
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        clienteService.remove(clienteService.loadById(id));
    }
    
    @GetMapping("/{id}")
    public Cliente loadById(@PathVariable Long id) {
        return clienteService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Cliente> listar() {
        return clienteService.findAll();
    }
}