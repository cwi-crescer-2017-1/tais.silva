/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class AtorService {

    @Autowired
    AtorRepositorio atorRepositorio;   
    
    public Iterable<Ator> list() {
      return atorRepositorio.findAll();
    }

}
