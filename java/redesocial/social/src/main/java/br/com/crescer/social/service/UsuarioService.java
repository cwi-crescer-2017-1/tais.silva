/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    
    public Map<String, Object> usuarioLogado(Authentication authentication) {
        User usuario = Optional
                .ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", usuario);
        return hashMap;
    }
    
    public String usuarioLogadoEmail(Authentication authentication) {
        return Optional
                .ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null)
                .getUsername();
    }
    
    public Usuario getUsuario() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(usuarioRepositorio::findByEmail)
                .orElse(null);
    }
    
    public Usuario save(Usuario usuario) {  
      usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha())); 
      return usuarioRepositorio.save(usuario);
    }
    
    public Usuario atualizar(Usuario usuarioAtualizado, Usuario logado) {        
      logado.setNome(usuarioAtualizado.getNome());
      logado.setDataNascimento(usuarioAtualizado.getDataNascimento());
      logado.setImagem(usuarioAtualizado.getImagem());
      if(usuarioAtualizado.getSenha() != null){
        logado.setSenha(new BCryptPasswordEncoder().encode(usuarioAtualizado.getSenha()));        
      }
      logado.setSexo(usuarioAtualizado.getSexo());
      return usuarioRepositorio.save(logado);
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
    
    public Iterable<Usuario> findAllNovos(List<Long> amigos) {  
      return usuarioRepositorio.findByIdNotIn(amigos);
    }
}
