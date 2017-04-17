
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test 
    public void vestirArmaduraDeixaArmaduraVestida(){
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste 
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test 
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() {
        Saint hyoga = new Saint ("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test 
    public void mostrarGeneroDeNascimentoDosSaints() {
        Armadura aries = new Armadura ("Áries", Categoria.OURO);
        Saint shion = new Saint("Shion", aries);
        boolean resultado = false;
        if (shion.getGenero() == Genero.NAO_INFORMADO){
            resultado = true;
        }
        assertEquals(true, resultado);

    }

    @Test
    public void alterarGeneroParaMasculino() {
        Armadura andromeda = new Armadura ("Andrômeda", Categoria.OURO);
        Saint shun = new Saint("Shun", andromeda);
        shun.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, shun.getGenero());
    }

    @Test
    public void nascerComStatusVivo() {
        Saint shiryu = new Saint("Shiryu", new Armadura ("Dragão", Categoria.BRONZE));
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSerC100() {
        Saint shiryu = new Saint("Shiryu", new Armadura ("Dragão", Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test 
    public void perderDanoComValor10() { 
        // Arrange 
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE)); 
        // Act 
        shiryu.perderVida(10); 
        // Assert 
        assertEquals(90, shiryu.getVida(), 0.01); 
    } 

    @Test 
    public void perderDanoComValor100() { 
        // Arrange 
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE)); 
        // Act 
        shiryu.perderVida(100); 
        // Assert 
        assertEquals(0, shiryu.getVida(), 0.01); 
    } 

    @Test 
    public void perderDanoComValorMenos1000() { 
        // Arrange 
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE)); 
        // Act 
        shiryu.perderVida(-1000); 
        // Assert 
        assertEquals(1100, shiryu.getVida(), 0.01); 
    } 

    @Test 
    public void categoriaSaint1MaiorQueSaint2() { 
        // Arrange 
        Saint shaina = new Saint("Shaina", new Armadura("Serpente", Categoria.PRATA)); 
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE)); 
        Batalha batalha = new Batalha(shaina, hyoga); 
        // Act 
        batalha.iniciar(); 
        // Assert 
        assertEquals(100, shaina.getVida(), 0.01); 
        assertEquals(90, hyoga.getVida(), 0.01); 
    } 

    @Test 
    public void categoriasIguaisSaint2PerdeVida() { 
        // Arrange 
        Saint aldebaran = new Saint("Aldebaran", new Armadura("Touro", Categoria.OURO)); 
        Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura("Câncer", Categoria.OURO)); 
        Batalha batalha = new Batalha(aldebaran, mascaraMorte); 
        // Act 
        batalha.iniciar(); 
        // Assert 
        assertEquals(100, aldebaran.getVida(), 0.01); 
        assertEquals(90, mascaraMorte.getVida(), 0.01); 
    } 

    @Test 
    public void categoriaSaint2MaiorSaint1PerdeVida() { 
        // Arrange 
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE)); 
        Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura("Câncer", Categoria.OURO)); 
        Batalha batalha = new Batalha(ikki, mascaraMorte); 
        // Act 
        batalha.iniciar(); 
        // Assert 
        assertEquals(90, ikki.getVida(), 0.01); 
        assertEquals(100, mascaraMorte.getVida(), 0.01); 
    } 

    @Test 
    public void criarSaintNasceCom5SentidosDespertados() { 
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE)); 
        assertEquals(5, shiryu.getQtsSentidosDespertados()); 
    } 
    
    @Test
    public void criarSaintNasceCom6SentidosDespertados() {
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.PRATA)); 
        assertEquals(6, shiryu.getQtsSentidosDespertados());
    }
        
    @Test
    public void criarSaintNasceCom7SentidosDespertados() {
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.OURO)); 
        assertEquals(7, shiryu.getQtsSentidosDespertados());
    }
}
