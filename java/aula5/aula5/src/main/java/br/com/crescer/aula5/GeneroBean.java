package br.com.crescer.aula5;

import br.com.crescer.aula4.tema.Genero;
import br.com.crescer.aula4.tema.GeneroDaoImpl;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author carloshenrique
 */
@Stateless
public class GeneroBean {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public Genero save(Genero genero) {
//        entityManager.persist(genero);

        return new GeneroDaoImpl(entityManager).save(genero);
    }

    public List<Genero> findAll() {
        return new GeneroDaoImpl(entityManager).findAll();
    }

}
