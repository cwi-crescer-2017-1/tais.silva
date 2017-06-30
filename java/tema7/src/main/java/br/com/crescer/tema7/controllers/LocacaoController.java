/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.controllers;

import br.com.crescer.tema7.entidades.Locacao;
import br.com.crescer.tema7.services.LocacaoService;
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
@RequestMapping(value = "/locacao")
public class LocacaoController {
    
    @Autowired
    private LocacaoService locacaoService;
    
    @PostMapping
    public Locacao save(@RequestBody Locacao locacao) {
        return locacaoService.save(locacao);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        locacaoService.remove(locacaoService.loadById(id));
    }
    
    @GetMapping("/{id}")
    public Locacao loadById(@PathVariable Long id) {
        return locacaoService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Locacao> listar() {
        return locacaoService.findAll();
    }
}