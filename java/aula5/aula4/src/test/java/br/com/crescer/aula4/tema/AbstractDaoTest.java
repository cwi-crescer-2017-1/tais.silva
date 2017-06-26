package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author carloshenrique
 */
public abstract class AbstractDaoTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeClass
    public static void beforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TEST");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void afterClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

}
