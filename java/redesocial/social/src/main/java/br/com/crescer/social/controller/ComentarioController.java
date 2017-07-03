/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Comentario;
import br.com.crescer.social.service.ComentarioService;
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
@RequestMapping(value = "/comentario")
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping
    public Iterable<Comentario> listar() {
        return comentarioService.findAll();
    }  
   
    @GetMapping(value = "/{id}")
    public Comentario loadById(@PathVariable Long id) {
        return comentarioService.loadById(id);
    }
    
    @PostMapping
    public Comentario save(@RequestBody Comentario comentario) {
        return comentarioService.save(comentario);
    }
    
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable Long id) {
        comentarioService.remove(comentarioService.loadById(id));
    }   
}