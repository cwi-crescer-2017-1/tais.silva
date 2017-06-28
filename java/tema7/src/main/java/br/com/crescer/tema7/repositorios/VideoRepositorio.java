/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema7.repositorios;

import br.com.crescer.tema7.entidades.Video;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tais.silva
 */
public interface VideoRepositorio extends CrudRepository<Video, Long>  {
    
}
