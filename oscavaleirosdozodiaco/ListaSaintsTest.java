import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {

    @Test public void buscarSaintExistentePorNome() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        lista.adicionar(june);
        assertEquals(june, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint june2 = new SilverSaint("June", "Camaleão");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertEquals(june2, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintInexistente() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint june2 = new SilverSaint("June", "Camaleão");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertNull(lista.buscarPorNome("San Junipero"));
    }

    @Test public void buscarSaintComListaVazia() {
        assertNull(new ListaSaints().buscarPorNome("Seiya"));
    }

    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        misty.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(100);
        june.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    // TipoOrdenacao.ASCENDENTE

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    // TipoOrdenacao.DESCENDENTE

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }

    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        GoldSaint dohko = new GoldSaint("Dohko", "Touro");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        String separador = System.getProperty("line.separator");
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"+separador+"Dohko,10.0,Touro,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, lista.getCSV());
    }
    
    @Test
    public void diffSaintRecebeOutraListaIdentificaOQueNaoExisteNela() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        GoldSaint dohko = new GoldSaint("Dohko", "Touro");
        Saint misty2 = new SilverSaint("Misty2", "Lagarto");
        BronzeSaint shun2 = new BronzeSaint("Shun2", "Andrômeda");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(june);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(shun);        
        listaSaints.adicionar(dohko);
        ListaSaints listaSaints2 = new ListaSaints();
        listaSaints2.adicionar(june);
        listaSaints2.adicionar(dohko);
        listaSaints2.adicionar(misty2);
        listaSaints2.adicionar(shun2);
        ListaSaints esperado = new ListaSaints();
        esperado.adicionar(misty);
        esperado.adicionar(shun);
        ListaSaints resposta = listaSaints.diff(listaSaints2);
        assertEquals(esperado.get(0), resposta.get(0));
        assertEquals(esperado.get(1), resposta.get(1));
        assertEquals(esperado.getSize(), resposta.getSize());
    }
    
    @Test
    public void intersecSaintRecebeOutraListaIdentificaOQueTemIgual() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        GoldSaint dohko = new GoldSaint("Dohko", "Touro");
        SilverSaint misty2 = new SilverSaint("Misty2", "Lagarto");
        BronzeSaint shun2 = new BronzeSaint("Shun2", "Andrômeda");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(june);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(shun);        
        listaSaints.adicionar(dohko);
        ListaSaints listaSaints2 = new ListaSaints();
        listaSaints2.adicionar(june);
        listaSaints2.adicionar(dohko);
        listaSaints2.adicionar(misty2);
        listaSaints2.adicionar(shun2);
        ListaSaints esperado = new ListaSaints();
        esperado.adicionar(june);
        esperado.adicionar(dohko);
        ListaSaints resposta = listaSaints.intersec(listaSaints2);
        assertEquals(esperado.get(0), resposta.get(0));
        assertEquals(esperado.get(1), resposta.get(1));
        assertEquals(esperado.getSize(), resposta.getSize());
    }

}