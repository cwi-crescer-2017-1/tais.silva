package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class LocacaoDaoImpl extends AbstractCrudDao<Locacao, Long> implements LocacaoDao {

    private final EntityManager entityManager;

    public LocacaoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
