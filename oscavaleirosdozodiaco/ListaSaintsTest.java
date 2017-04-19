import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void testarBuscarPorNome() throws Exception{
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        SilverSaint marin = new SilverSaint("Marin", new Armadura(new Constelacao("Águia"), Categoria.PRATA));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints listaTest = new ListaSaints();
        listaTest.adicionar(seiya);
        listaTest.adicionar(marin);
        listaTest.adicionar(afrodite);
        assertEquals(marin, listaTest.buscarPorNome("Marin"));   
    }       
}
