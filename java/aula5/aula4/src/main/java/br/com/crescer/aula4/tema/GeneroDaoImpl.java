package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class GeneroDaoImpl extends AbstractCrudDao<Genero, Long> implements GeneroDao {

    private final EntityManager entityManager;

    public GeneroDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
