public class Batalha {

    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() {
        int valor1 = this.saint1.getArmadura().getCategoria().getValor();
        int valor2 = this.saint2.getArmadura().getCategoria().getValor();
        boolean statusSaints = this.saint2.getStatus() == Status.VIVO && this.saint2.getStatus() == Status.VIVO;
        while (statusSaints) {
            if (valor1 >= valor2) {
                this.saint1.getProximoMovimento().executar();
                if(this.saint2.getStatus() != Status.MORTO){ break; }
                this.saint2.getProximoMovimento().executar();
            } else {
                this.saint2.getProximoMovimento().executar();
                if(this.saint1.getStatus() != Status.MORTO){ break; }
                this.saint1.getProximoMovimento().executar();
            }
            
        }
    }
}