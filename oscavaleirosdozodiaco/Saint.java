public class Saint {
  private String nome;
  private Armadura armadura;
  private boolean armaduraVestida;
  private Genero genero = Genero.NAO_INFORMADO;
  private Status status = Status.VIVO; 
  private double vida = 100.0;
  
  // armadura 
  public Saint(String nome, Armadura armadura) {
      this.nome = nome;
      this.armadura = armadura;
    }
    
  public void vestirArmadura() {
      this.armaduraVestida = true;
    }
  
  public boolean getArmaduraVestida(){
      return this.armaduraVestida;
    } 
    
  public Genero getGenero() {
        return this.genero;
    }
    
  public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
  public void setStatus(Status status) {
      this.status = status;
    }
    
  public Status getStatus() {
      return this.status;
    }
    
  public void perderVida(double dano) {
      this.vida -= dano;
      
      /* 
         if (dano >= this.vida) {
          this.vida = 0.0;
          this.status = Status.MORTO;
        } else {
            this.vida -= dano;
        }*/
    }
  
  public double getVida() {
      return this.vida;
    }
    
  public double setVida(double novaVida){
      return this.vida = novaVida;
    }
    
  public Armadura getArmadura(){
      return this.armadura;
    }
}


