package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author carloshenrique
 */
public class Run {

    public static void main(String[] args) {        
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        
        
//        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
//        final EntityManager em = emf.createEntityManager();
//        
//        final Cliente cliente = em.find(Cliente.class, 1l);    
//        
//        System.out.println(cliente.getNome());
//        
//        final Cliente cliente = new Cliente(); 
//        cliente.setId(1l);
//        cliente.setNome("Carlos");//
//        em.getTransaction().begin();
//        em.persist(cliente);        
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();
    }
}
