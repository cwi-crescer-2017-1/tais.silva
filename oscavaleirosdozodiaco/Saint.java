public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private double vida = 100.0;
    private int qtsSentidosDespertados = 5;

    // armadura 
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;

        if (this.armadura.getCategoria() == Categoria.PRATA) {
            this.qtsSentidosDespertados = 6;
        } else if (this.armadura.getCategoria() == Categoria.OURO) {
            this.qtsSentidosDespertados = 7;
        }
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

    public int getQtsSentidosDespertados(){
        return this.qtsSentidosDespertados;
    }
}

