package br.com.crescer.aula4.tema;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author carloshenrique
 * @param <Entity>
 * @param <ID>
 */
public abstract class AbstractCrudDao<Entity, ID> implements CrudDao<Entity, ID> {

    private final Class<Entity> entityClass;

    public AbstractCrudDao() {
        this.entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Entity save(Entity entity) {
//        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
//        getEntityManager().getTransaction().commit();
        return entity;
    }

    @Override
    public void remove(Entity entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public Entity loadById(ID id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<Entity> findAll() {
        return getEntityManager().createQuery("select p from " + entityClass.getSimpleName() + " p").getResultList();
//        return ((Session) getEntityManager().unwrap(Session.class)).createCriteria(entityClass).list();
    }
    
    abstract EntityManager getEntityManager();

}
