package br.com.crescer.aula4.tema;

import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 */
public class FuncionarioDaoImpl extends AbstractCrudDao<Funcionario, Long> implements FuncionarioDao {

    private final EntityManager entityManager;

    public FuncionarioDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
