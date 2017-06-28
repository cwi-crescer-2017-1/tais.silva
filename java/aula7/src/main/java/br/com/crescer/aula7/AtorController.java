/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tais.silva
 */
@RestController
@RequestMapping(value = "/ator")
public class AtorController {
    
    @Autowired
    private AtorService atorService;
    
    @RequestMapping(value = "/listar")
    public Iterable<Ator> listar() {
        return atorService.list();
    }
}