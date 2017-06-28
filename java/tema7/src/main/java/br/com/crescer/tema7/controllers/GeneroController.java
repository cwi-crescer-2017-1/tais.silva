/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.controllers;

import br.com.crescer.tema7.entidades.Genero;
import br.com.crescer.tema7.services.GeneroService;
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
@RequestMapping(value = "/genero")
public class GeneroController {
    
    @Autowired
    private GeneroService generoService;
    
    @PostMapping
    public Genero save(@RequestBody Genero genero) {
        return generoService.save(genero);
    }
    
    @DeleteMapping
    public void remove(Genero t) {
        generoService.remove(t);
    }
    
    @GetMapping("/{id}")
    public Genero loadById(@PathVariable Long id) {
        return generoService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Genero> listar() {
        return generoService.findAll();
    }
}