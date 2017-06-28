/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.services;

import br.com.crescer.tema7.entidades.Video;
import br.com.crescer.tema7.repositorios.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tais.silva
 */

@Service
public class VideoService {

    @Autowired
    VideoRepositorio videoRepositorio;  
    
    public Video save(Video t) {
      return videoRepositorio.save(t);
    }
    
    public void remove(Video t) {
      videoRepositorio.delete(t);
    }
    
    public Video loadById(Long id) {
      return videoRepositorio.findOne(id);
    }
    
    public Iterable<Video> findAll() {
      return videoRepositorio.findAll();
    }
}
