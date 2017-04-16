

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
        boolean resultado = false;
        if (shun.getGenero() == Genero.MASCULINO){
            resultado = true;
        }
       assertEquals(true, resultado);
    }
    
    @Test
    public void nascerComStatusVivo() {
        Armadura dragao = new Armadura ("Dragão", Categoria.BRONZE);
        Saint shiryu = new Saint("Shiryu", dragao);
        boolean resultado = false;
        if (shiryu.getStatus() == Status.VIVO){
            resultado = true;
        }
       assertEquals(true, resultado);
    }
    
    @Test
    public void perderMetadeDaVida() {
        Armadura dragao = new Armadura ("Dragão", Categoria.BRONZE);
        Saint shiryu = new Saint("Shiryu", dragao);
        shiryu.perderVida(50.0);
        boolean resultado = false;
        if (shiryu.getVida() == 50.0){
            resultado = true;
        }
       assertEquals(true, resultado);
    }
}
 