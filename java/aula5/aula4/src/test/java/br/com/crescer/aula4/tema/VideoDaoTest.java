package br.com.crescer.aula4.tema;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author carloshenrique
 */
public class VideoDaoTest extends AbstractDaoTest {

    private final VideoDao videoDao;

    public VideoDaoTest() {
        this.videoDao = new VideoDaoImpl(getEntityManager());
    }

    /**
     * Test of findAll method, of class VideoDao.
     */
    @Test
    public void testFindAll() {
        final Video genero = this.createVideo();
        final List<Video> generos = videoDao.findAll();
        assertTrue(generos.stream()
                .map(Video::getNome)
                .anyMatch(genero.getNome()::equals));
    }

    /**
     * Test of loadById method, of class VideoDao.
     */
    @Test
    public void testLoadById() {
        final Video video = this.createVideo();
        assertEquals(video.getNome(), videoDao.loadById(video.getId()).getNome());
    }

    /**
     * Test of save method, of class VideoDao.
     */
    @Test
    public void testSave() {
        final Video video = new Video();
        video.setNome("Teste");
        video.setValor(BigDecimal.ZERO);
        videoDao.save(video);
        assertEquals(video.getNome(), getEntityManager().find(Video.class, video.getId()).getNome());
    }

    /**
     * Test of remove method, of class VideoDao.
     */
    @Test
    public void testRemove() {
        final Video video = createVideo();
        videoDao.remove(video);
        assertNull(getEntityManager().find(Video.class, video.getId()));
    }

    private Video createVideo() {
        final Video video = new Video();
        video.setNome("Teste");
        video.setValor(BigDecimal.ZERO);
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(video);
        getEntityManager().getTransaction().commit();
        return video;
    }

}
