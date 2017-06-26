/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema4;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Taís
 */
public class Main {
    public static void main(String[] args) {
    
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = entityManagerFactory.createEntityManager();
        
        Cliente cliente = new Cliente("Tais", "111111110", "11111111", "Catuaba", "Ula", "Fuia", "11", "tais.silva@cwi.com.br", "519999999", "15545464545", new Date(03/07/1994));
        ClienteDao repositorioCliente = new ClienteDao(em);
 
        repositorioCliente.save(cliente);
            
    }
}
