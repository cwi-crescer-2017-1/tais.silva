/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.controllers;

import br.com.crescer.tema7.entidades.Video;
import br.com.crescer.tema7.services.VideoService;
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
@RequestMapping(value = "/video")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @PostMapping
    public Video save(@RequestBody Video video) {
        return videoService.save(video);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        videoService.remove(videoService.loadById(id));
    }
    
    @GetMapping("/{id}")
    public Video loadById(@PathVariable Long id) {
        return videoService.loadById(id);
    }
    
    @GetMapping(value = "/listar")
    public Iterable<Video> listar() {
        return videoService.findAll();
    }
}