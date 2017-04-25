public class Batalha {

    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() {
        int valor1 = this.saint1.getArmadura().getCategoria().getValor();
        int valor2 = this.saint2.getArmadura().getCategoria().getValor();
        final double dano = 10;
        Saint saintEmAcao = null;

        if (valor1 >= valor2) {
            saintEmAcao = this.saint1;
            this.saint2.perderVida(dano);
        } else {
            saintEmAcao = this.saint2;
            this.saint1.perderVida(dano);
        }

        boolean nenhumMorto = true;
        while (nenhumMorto) {
            // 1. definindo quem vai atuar no round
            saintEmAcao = saintEmAcao == this.saint1 ? this.saint2 : this.saint1;
            // 2. executando próximo movimento
            Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
            proximoMovimento.executar();
            // 3. verificando se a batalha acabou
            nenhumMorto = this.saint1.getStatus() != Status.MORTO &&
            this.saint2.getStatus() != Status.MORTO;
        }

    }
}