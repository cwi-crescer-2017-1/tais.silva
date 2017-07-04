/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Reacao;
import br.com.crescer.social.service.ReacaoService;
import java.util.List;
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
@RequestMapping(value = "/reacao")
public class ReacaoController {
    
    @Autowired
    private ReacaoService reacaoService;
    
    @GetMapping (value = "/listar/{id}")
    public List<Reacao> listar(@PathVariable Long id) {
        return (List<Reacao>) reacaoService.reacoesListar(id);
    }  
    
    @GetMapping (value = "/count/{id}")
    public Long listarContador(@PathVariable Long id) {
        return reacaoService.reacoesContador(id);
    }
   
    @GetMapping(value = "/{id}")
    public Reacao loadById(@PathVariable Long id) {
        return reacaoService.loadById(id);
    }
    
    @PostMapping
    public Reacao save(@RequestBody Long idPost) {
        return reacaoService.save(idPost);
    }
    
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable Long id) {
        reacaoService.remove(id);
    }   
}