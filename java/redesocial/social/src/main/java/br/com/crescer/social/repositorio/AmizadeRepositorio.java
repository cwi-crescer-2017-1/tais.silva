/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Amizade;
import br.com.crescer.social.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tais.silva
 */
public interface AmizadeRepositorio extends CrudRepository<Amizade, Long>  {
    Amizade findById(Long id);
    Iterable<Amizade> findAllBySolicitante(Usuario solicitante);
    Iterable<Amizade> findAllBySolicitanteAndSituacao(Usuario solicitante, Character situacao);
    Iterable<Amizade> findAllBySolicitadoAndSituacao(Usuario solicitado, Character situacao);
}
