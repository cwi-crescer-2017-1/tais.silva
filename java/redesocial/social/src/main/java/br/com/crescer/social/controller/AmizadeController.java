/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Amizade;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.AmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping (value = "/listar")
    public Iterable<Amizade> listar() {
        return amizadeService.findAll();
    } 
    
    @GetMapping (value = "/novos")
    public Iterable<Usuario> listarNovos() {
        return amizadeService.findAllNovos();
    } 
    
    @GetMapping (value = "/pendentes")
    public Iterable<Amizade> listarPendentes() {
        return amizadeService.findAllPendentes();
    }
    
    @GetMapping (value = "/aceitas")
    public Iterable<Amizade> listarAceitos() {
        return amizadeService.findAllAceitos();
    }
   
    @GetMapping(value = "/{id}")
    public Amizade loadById(@PathVariable Long id) {
        return amizadeService.loadById(id);
    }
    
    @PostMapping
    public Amizade save(@RequestBody Long idSolicitado) {
        return amizadeService.save(idSolicitado);
    }
    
    @PutMapping (value = "/aceitar")
    public Amizade aceitar(@RequestBody Long id) {
        return amizadeService.atualizar(id);
    }
    
    @DeleteMapping (value = "/rejeitar")
    public void rejeitar(@RequestBody Long id) {
        amizadeService.remove(id);
    }  
}