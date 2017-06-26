/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema4;

import javax.persistence.EntityManager;

/**
 *
 * @author Taís
 */
public class ClienteDao extends AbstractDao<Cliente, Long> {    
    
    public ClienteDao(EntityManager em) {
        super(em, Cliente.class);
    }    
}
