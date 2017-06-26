package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class VideoDaoImpl extends AbstractCrudDao<Video, Long> implements VideoDao {

    private final EntityManager entityManager;

    public VideoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
