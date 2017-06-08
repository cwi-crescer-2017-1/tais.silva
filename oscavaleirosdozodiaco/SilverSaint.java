// C#, C++
// public class SilverSaint : Saint
public class SilverSaint extends Saint {

    public SilverSaint(String nome, String constelacao) throws Exception {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.PRATA));
        this.qtdSentidosDespertados = 6;
    }
}