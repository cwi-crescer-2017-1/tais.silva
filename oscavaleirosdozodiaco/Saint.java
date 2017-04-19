import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected int qtdSentidosDespertados;
    private int acumuladorProximoGolpe = 0;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }

    // camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return this.status;
    }

    public double getVida() {
        return this.vida;
    }

    public void perderVida(double dano) {

        if (dano < 0) {
            throw new InvalidParameterException("dano");
            //throw new IllegalArgumentException("dano");
        }

        if (vida - dano < 1) {
            this.status = Status.MORTO;
            this.vida = 0;
        } else {
            //this.vida = this.vida - dano;
            this.vida -= dano;
        }
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }
    
    private Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
    }
    
    public ArrayList getGolpes() {
        return getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        getConstelacao().adicionarGolpe(golpe);
    }
    
    public Object getProximoGolpe() {
        ArrayList golpes = getGolpes();
        int posicao = this.acumuladorProximoGolpe % golpes.size();
        this.acumuladorProximoGolpe++;
        return golpes.get(posicao);
    }
    
    public Categoria getCategoria(){
        return this.armadura.getCategoria();
    }
}
