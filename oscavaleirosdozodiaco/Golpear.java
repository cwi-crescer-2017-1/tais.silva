public class Golpear implements Movimento {
    private Saint golpeador, golpeado;
    public void Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;       
    }
    
    public void executar() {
        int fatorDano = golpeador.getProximoGolpe().getFatorDano();
        boolean armaduraEstaVestida = golpeador.getArmaduraVestida();
        if (armaduraEstaVestida) {
            fatorDano *= (1 + golpeador.getArmadura().getCategoria().getValor());
        }
        this.golpeado.perderVida(fatorDano);
    }
}