public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome, armadura);
        this.qtdSentidosDespertados = 7;
        String constelacao = armadura.getConstelacao().getNome(); 
        if ( !constelacao.equals("Áries") 
        && !constelacao.equals("Touro")
        && !constelacao.equals("Gêmeos")
        && !constelacao.equals("Câncer")
        && !constelacao.equals("Virgem")
        && !constelacao.equals("Leão")
        && !constelacao.equals("Libra")
        && !constelacao.equals("Escorpião")
        && !constelacao.equals("Sagitário")
        && !constelacao.equals("Capricórnio")
        && !constelacao.equals("Aquário")
        && !constelacao.equals("Peixes")) {
            // dar erro
            throw new Exception("Constelação inválida");
        }
    }
}