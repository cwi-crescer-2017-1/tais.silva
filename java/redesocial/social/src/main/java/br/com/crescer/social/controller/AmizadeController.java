/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Amizade;
import br.com.crescer.social.service.AmizadeService;
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
@RequestMapping(value = "/amizade")
public class AmizadeController {
    
    @Autowired
    private AmizadeService amizadeService;
    
    @GetMapping
    public Iterable<Amizade> listar() {
        return amizadeService.findAll();
    }  
   
    @GetMapping("/{id}")
    public Amizade loadById(@PathVariable Long id) {
        return amizadeService.loadById(id);
    }
    
    @PostMapping
    public Amizade save(@RequestBody Amizade amizade) {
        return amizadeService.save(amizade);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        amizadeService.remove(amizadeService.loadById(id));
    }   
}