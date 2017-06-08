public final class GoldSaint extends Saint {

    public GoldSaint(String nome, String constelacao) throws Exception {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
        try {
            this.qtdSentidosDespertados = 7;
        } catch (Exception e) {
            System.out.println("Erro de atribuição dos sentidos");
        }
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
            throw new ConstelacaoInvalidaException("Constelação inválida");
        }
    }

    public void moverNaVelocidadeDaLuz() {
        System.out.println(this.getNome() + " na velocidade da Luz!");
    }

    public String getNome() {
        return super.getNome() + "!!!!";
    }
}