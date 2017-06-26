package br.com.crescer.tema4;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 * @author Taís
 */
public abstract class AbstractDao<Entity, ID> implements CrudDao<Entity, ID>{

    private EntityManager em;
    private Class<Entity> entity;
    
    public AbstractDao(EntityManager em, Class<Entity> entity){
        this.em = em;
	this.entity = entity;
    }
    
    @Override
    public Entity save(Entity e) {
        em.getTransaction().begin();
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(entity);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Entity e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    @Override
    public Entity loadById(ID id) {
        return em.find(entity, id);
    }

    @Override
    public List<Entity> findAll() {
        Session session = em.unwrap(Session.class);
        return session.createCriteria(entity).list();
    }
    
}
