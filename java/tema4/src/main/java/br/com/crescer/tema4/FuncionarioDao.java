/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Taís
 */
public class FuncionarioDao extends AbstractDao<Funcionario, Long> {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    final EntityManager em = entityManagerFactory.createEntityManager();
    
    public FuncionarioDao(EntityManager em) {
        super(em, Funcionario.class);
    }    
}
