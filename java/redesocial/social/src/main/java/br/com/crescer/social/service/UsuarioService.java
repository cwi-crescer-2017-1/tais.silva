/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;   
    
    public Usuario save(Usuario usuario) {  
      usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha())); 
      return usuarioRepositorio.save(usuario);
    }
   
    public void remove(Usuario t) {
      usuarioRepositorio.delete(t);
    }
    
    public Usuario findByEmail(String email) {
      return usuarioRepositorio.findByEmail(email);
    }
    
    public Usuario loadById(Long id) {
      return usuarioRepositorio.findOne(id);
    }
    
    public Iterable<Usuario> findAll() {
      return usuarioRepositorio.findAll();
    }
}
