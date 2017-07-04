/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.Reacao;
import br.com.crescer.social.repositorio.ReacaoRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */
@Service
public class ReacaoService {

    @Autowired
    ReacaoRepositorio reacaoRepositorio;

    @Autowired
    PostService postService;

    @Autowired
    UsuarioService usuarioService;

    public Long reacoesContador(Long id) {
        Post post = postService.loadById(id);
        return reacaoRepositorio.countByPost(post);
    }

    public Iterable<Reacao> reacoesListar(Long id) {
        Post post = postService.loadById(id);
        return reacaoRepositorio.findByPost(post);
    }

    public Reacao save(Long idPost) {
        final Reacao reacao = new Reacao();
        reacao.setDataAtual(new Date());
        reacao.setPost(new Post(idPost));
        reacao.setUsuario(usuarioService.getUsuario());
        return reacaoRepositorio.save(reacao);
    }

    public void remove(Long id) {
        reacaoRepositorio.findByPost_idAndUsuario(id, usuarioService.getUsuario())
                .stream().forEach(reacaoRepositorio::delete);
    }

    public Reacao loadById(Long id) {
        return reacaoRepositorio.findOne(id);
    }

    public Iterable<Reacao> findAll() {
        return reacaoRepositorio.findAll();
    }
}
