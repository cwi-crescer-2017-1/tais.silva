import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaSaint1MaiorQueSaint2() throws Exception {
        // Arrange
        Constelacao serpente = new Constelacao("Serpente");
        Constelacao cisne = new Constelacao("Cisne");
        Saint shaina = new Saint("Shaina", new Armadura(serpente, Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura(cisne, Categoria.BRONZE));
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
        Constelacao touro = new Constelacao("Touro");
        Constelacao cancer = new Constelacao("Câncer");
        Saint aldebaran = new Saint("Aldebaran", new Armadura(touro, Categoria.OURO));
        Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura(cancer, Categoria.OURO));
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
        Constelacao fenix = new Constelacao("Fênix");
        Constelacao cancer = new Constelacao("Câncer");
        Saint ikki = new Saint("Ikki", new Armadura(fenix, Categoria.BRONZE));
        Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura(cancer, Categoria.OURO));
        Batalha batalha = new Batalha(ikki, mascaraMorte);
        // Act
        batalha.iniciar();
        // Assert
        assertEquals(90, ikki.getVida(), 0.01);
        assertEquals(100, mascaraMorte.getVida(), 0.01);
    }
}