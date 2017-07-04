/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Amizade;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.AmizadeRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */
@Service
public class AmizadeService {

    @Autowired
    AmizadeRepositorio amizadeRepositorio;
    
    @Autowired
    UsuarioService usuarioService;
    
    public Iterable<Amizade> findAll() {        
        return amizadeRepositorio.findAllBySolicitante(usuarioService.getUsuario());
    }
    
    public Iterable<Usuario> findAllNovos() {      
        List<Amizade> amigos = (List<Amizade>) findAllAceitos();
        
        List<Long> result = new ArrayList<>();
        result.add(usuarioService.getUsuario().getId());
        
        amigos
            .stream()
            .map(Amizade::getSolicitado)
            .map(Usuario::getId)
            .forEach(result::add);       
        
        return usuarioService.findAllNovos(result);
    }
    
    public Iterable<Amizade> findAllPendentes() {                
        return amizadeRepositorio.findAllBySolicitanteAndSituacao(usuarioService.getUsuario(), 'p');
    }
    
    public Iterable<Amizade> findAllSolitacoesPendentes() {                
        return amizadeRepositorio.findAllBySolicitadoAndSituacao(usuarioService.getUsuario(), 'p');
    }
    
    public Iterable<Amizade> findAllAceitos() {                
        return amizadeRepositorio.findAllBySolicitanteAndSituacao(usuarioService.getUsuario(), 'a');
    }

    public Amizade save(Amizade t) {
        return amizadeRepositorio.save(t);
    }

    public void remove(Long id) {        
        amizadeRepositorio.delete(loadById(id));
    }

    public Amizade loadById(Long id) {
        return amizadeRepositorio.findOne(id);
    }
    
    public Amizade save(Long idSolicitado) {
        Amizade amizade = new Amizade();
        amizade.setSolicitado(usuarioService.loadById(idSolicitado));
        amizade.setDataAtual(new Date());
        amizade.setSolicitante(usuarioService.loadById(usuarioService.getUsuario().getId()));
        amizade.setSituacao('p');
        return amizadeRepositorio.save(amizade);
    }

    public Amizade atualizar(Long id) {
        Amizade amizade = loadById(id);
        amizade.setSituacao('a');
        return amizadeRepositorio.save(amizade);
    }
}
