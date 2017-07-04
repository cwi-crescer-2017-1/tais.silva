/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.repositorio.PostPageRepositorio;
import br.com.crescer.social.repositorio.PostRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class PostService {

    @Autowired
    PostRepositorio postRepositorio;  
    PostPageRepositorio postPageRepositorio;  
    
    @Autowired
    AmizadeService amizadeService;  
    
    public Post save(Post t) {
      return postRepositorio.save(t);
    }
    
    public void remove(Post t) {
      postRepositorio.delete(t);
    }
    
    public Post loadById(Long id) {
      return postRepositorio.findOne(id);
    }
    
    public Iterable<Post> findAll() {      
      return postRepositorio.findAll();
    }
    
    public Page<Post> findAllPage() {
        return postPageRepositorio.findAll(new PageRequest(0, 5));
    }
}
