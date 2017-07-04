/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.Usuario;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tais.silva
 */
public interface PostRepositorio extends CrudRepository<Post, Long>  {
   // List<Post> findByUsuarioInLista(Iterable<Usuario> lista);
    //Iterable<Post> findByUsuario(Usuario usuario);
}
