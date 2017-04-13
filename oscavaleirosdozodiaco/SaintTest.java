

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
}
 