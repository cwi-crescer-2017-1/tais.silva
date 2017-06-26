package br.com.crescer.tema4;

import java.util.List;

/**
 * @author carloshenrique
 * @param <Entity>
 * @param <ID>
 */
public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
    
}

