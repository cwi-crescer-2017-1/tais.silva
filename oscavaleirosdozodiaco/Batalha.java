public class Batalha { 
 
    private Saint saint1, saint2; 
 
    public Batalha(Saint saint1, Saint saint2) { 
        this.saint1 = saint1; 
        this.saint2 = saint2; 
    } 
 
    public void iniciar() { 
        int valor1 = this.saint1.getArmadura().getCategoria().getValor(); 
        int valor2 = this.saint2.getArmadura().getCategoria().getValor(); 
         
        if (valor1 > valor2) { 
            this.saint2.perderVida(10); 
        } else if (valor1 == valor2) { 
            this.saint2.perderVida(10); 
        } else { 
            this.saint1.perderVida(10); 
        } 
         
    } 
}
