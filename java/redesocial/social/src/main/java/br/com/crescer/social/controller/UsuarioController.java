/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping(value = "/{id}")
    public Usuario loadById(@PathVariable Long id) {
        return usuarioService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Usuario> listar() {
        return usuarioService.findAll();
    }  
    
    @GetMapping
    public Map<String, Object> pegarUsuario(Authentication authentication) {
        User usuario = Optional.ofNullable(authentication)
                                .map(Authentication::getPrincipal)
                                .map(User.class::cast)
                                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", usuario);
        return hashMap;
    }
    
    @GetMapping(value = "/email/{email:.+}")
    public Usuario loadByEmail(@PathVariable String email) {        
        return usuarioService.findByEmail(email);
    }
    
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {    
        return usuarioService.save(usuario);
    }
    
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable Long id) {
        usuarioService.remove(usuarioService.loadById(id));
    }   
}