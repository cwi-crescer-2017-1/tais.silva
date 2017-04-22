import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaSaint1MaiorQueSaint2() throws Exception {
        // Arrange
        SilverSaint shaina = new SilverSaint("Shaina", "Serpente");
        BronzeSaint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Batalha batalha = new Batalha(shaina, hyoga);
        // Act
        batalha.iniciar();
        // Assert
        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);
    }
    
    @Test
    public void categoriasIguaisSaint2PerdeVida() throws Exception {
        // Arrange
        GoldSaint aldebaran = new GoldSaint("Aldebaran", "Touro");
        GoldSaint mascaraMorte = new GoldSaint("Máscara da Morte", "Câncer");
        Batalha batalha = new Batalha(aldebaran, mascaraMorte);
        // Act
        batalha.iniciar();
        // Assert
        assertEquals(100, aldebaran.getVida(), 0.01);
        assertEquals(90, mascaraMorte.getVida(), 0.01);
    }
    
    @Test
    public void categoriaSaint2MaiorSaint1PerdeVida() throws Exception {
        // Arrange
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        GoldSaint mascaraMorte = new GoldSaint("Máscara da Morte", "Câncer");
        Batalha batalha = new Batalha(ikki, mascaraMorte);
        // Act
        batalha.iniciar();
        // Assert
        assertEquals(90, ikki.getVida(), 0.01);
        assertEquals(100, mascaraMorte.getVida(), 0.01);
    }
}