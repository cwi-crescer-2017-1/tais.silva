package br.com.crescer.aula4.tema;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloshenrique
 */
public class LocacaoDaoTest extends AbstractDaoTest {

    private final LocacaoDao locacaoDao;

    public LocacaoDaoTest() {
        this.locacaoDao = new LocacaoDaoImpl(getEntityManager());
    }

    /**
     * Test of findAll method, of class LocacaoDao.
     */
    @Test
    public void testFindAll() {
        final Locacao genero = this.createLocacao();
        final List<Locacao> generos = locacaoDao.findAll();
        assertTrue(generos.stream()
                .map(Locacao::getIdCliente)
                .anyMatch(genero.getIdCliente()::equals));
    }

    /**
     * Test of loadById method, of class LocacaoDao.
     */
    @Test
    public void testLoadById() {
        final Locacao locacao = this.createLocacao();
        assertEquals(locacao.getIdCliente(), locacaoDao.loadById(locacao.getId()).getIdCliente());
    }

    /**
     * Test of save method, of class LocacaoDao.
     */
    @Test
    public void testSave() {
        final Locacao locacao = new Locacao();
        locacao.setIdCliente(createCliente());
        locacaoDao.save(locacao);
        assertEquals(locacao.getIdCliente(), getEntityManager().find(Locacao.class, locacao.getId()).getIdCliente());
    }

    /**
     * Test of remove method, of class LocacaoDao.
     */
    @Test
    public void testRemove() {
        final Locacao locacao = createLocacao();
        locacaoDao.remove(locacao);
        assertNull(getEntityManager().find(Locacao.class, locacao.getId()));
    }

    private Locacao createLocacao() {
        final Locacao locacao = new Locacao();
        locacao.setIdCliente(createCliente());
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(locacao);
        getEntityManager().getTransaction().commit();
        return locacao;
    }

    private Cliente createCliente() {
        final Cliente cliente = new Cliente();
        cliente.setNome("Carlos Henrique Nonnemacher");
        cliente.setCpf("01041158076");
        cliente.setCelular("9999999999");
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(cliente);
        getEntityManager().getTransaction().commit();
        return cliente;
    }

}
