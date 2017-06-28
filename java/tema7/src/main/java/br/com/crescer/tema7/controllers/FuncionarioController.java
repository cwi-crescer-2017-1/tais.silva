/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.controllers;

import br.com.crescer.tema7.entidades.Funcionario;
import br.com.crescer.tema7.services.FuncionarioService;
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
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }
    
    @DeleteMapping
    public void remove(Funcionario t) {
        funcionarioService.remove(t);
    }
    
    @GetMapping("/{id}")
    public Funcionario loadById(@PathVariable Long id) {
        return funcionarioService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Funcionario> listar() {
        return funcionarioService.findAll();
    }
}