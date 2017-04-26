import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest
{
    @Test
    public void estouComSorte() {
        Sorteador sorteador = new DadoFalso(4);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertTrue(sorte.estouComSorte());
    }
 
    @Test
    public void estouSemSorte() {
        Sorteador sorteador = new DadoFalso(1);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertFalse(sorte.estouComSorte());
    }
}
