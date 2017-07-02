/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Reacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tais.silva
 */
public interface ReacaoRepositorio extends CrudRepository<Reacao, Long>  {
    
}
