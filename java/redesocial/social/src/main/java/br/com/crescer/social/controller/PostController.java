/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.service.PostService;
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
@RequestMapping(value = "/post")
public class PostController {
    
    @Autowired
    private PostService postService;
        
    @GetMapping
    public Iterable<Post> listar() {
        return postService.findAllPage();
    }
    
    @GetMapping(value = "/todos")
    public Iterable<Post> listarTodos() {
        return postService.findAll();
    }  
   
    @GetMapping("/{id}")
    public Post loadById(@PathVariable Long id) {
        return postService.loadById(id);
    }
    
    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        postService.remove(postService.loadById(id));
    }   
}