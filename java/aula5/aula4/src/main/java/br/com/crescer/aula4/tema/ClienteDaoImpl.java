package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class ClienteDaoImpl extends AbstractCrudDao<Cliente, Long> implements ClienteDao {

    private final EntityManager entityManager;

    public ClienteDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
