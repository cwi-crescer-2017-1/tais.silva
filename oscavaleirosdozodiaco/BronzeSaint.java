public class BronzeSaint extends Saint {
    public BronzeSaint(String nome, Armadura armadura) throws Exception {
        //chamando o construtor de Saint
        super(nome, armadura);
        this.qtdSentidosDespertados = 5;
    }
}