public class AtaqueDuplo implements Movimento
{
    private Saint golpeador, golpeado;
    public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        Sorteador sorteador = new DadoD6();
        int numeroSorteado = sorteador.sortear();
        int fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        boolean umTercoDeSorte = numeroSorteado == 1 || numeroSorteado == 4;
        if (!golpeado.getProtecao()) {
            if (umTercoDeSorte) { 
                fatorDano *= 2;     
            } else {
                double cincoPorcentoDaVida = golpeador.getVida() * 0.05;
                golpeador.perderVida(cincoPorcentoDaVida);
            }
            golpeado.perderVida(fatorDano);
        } else { golpeado.setProtecao(false); }
    }
}
