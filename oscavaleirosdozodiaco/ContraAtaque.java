public class ContraAtaque implements Movimento
{ 	private Saint golpeador, golpeado;  
    public ContraAtaque(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        boolean golpeadoComSorte = golpeado.getVida() < 50 && golpeado.getArmaduraVestida() == false;
        boolean fatorSorte = (new DadoD6().sortear()) < 5;
        if (golpeadoComSorte && fatorSorte) {
            double perderVida25 = golpeador.getVida() * 0.25;
            golpeador.perderVida(perderVida25);
            golpeado.setProtecao(true);
        }        
    }
}
