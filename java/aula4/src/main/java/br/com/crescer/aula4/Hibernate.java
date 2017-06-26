package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * @author carloshenrique
 */
public class Hibernate {

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        final Session session = entityManager.unwrap(Session.class);
//        final Cliente cliente = (Cliente) session.load(Cliente.class, 1L);
//        cliente.setNome("Carlos");
//        
//        session.saveOrUpdate(cliente);
//        criteria.add(Restrictions.ilike("nome", "Henrique", MatchMode.ANYWHERE));
//        criteria.setMaxResults(1);
//        final Cliente cliente =  (Cliente) criteria.uniqueResult();
        final Cliente cliente = new Cliente();
        cliente.setNome("JPA%");

        final Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Example.create(cliente));
        criteria.setMaxResults(1);
        criteria.uniqueResult();

        System.out.println(((Cliente)criteria.uniqueResult()).getNome());
        
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
