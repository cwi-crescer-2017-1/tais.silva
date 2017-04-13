public class Saint {
  private String nome;
  private Armadura armadura;
  private boolean armaduraVestida;
  private Genero genero;
  
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

}


