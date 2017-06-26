package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author carloshenrique
 */
public class JPA {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();

        final Cliente cliente = em.find(Cliente.class, 1l);
        cliente.setNome("JPA - TEST");
        em.detach(cliente);
        
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();

        System.out.println(cliente.getNome());

//        em.persist(cliente);
        em.close();
        emf.close();

    }
}
