package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author carloshenrique
 */
public class JPA1 {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//
//        final Pessoa pessoa = new Pessoa(1l, "Carlos");
//        final Filho filho = new Filho(1l, "Pedro");
//        filho.setPessoa(pessoa);
        
        final Query query = em.createQuery("select f from Filho f where f.id = :id");
        query.setParameter("id", 1L);
        
        final Filho filho = (Filho) query.getSingleResult();
        
        System.out.println(filho.getNome());
        System.out.println(filho.getPessoa().getNome());
        
//        em.persist(filho);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
