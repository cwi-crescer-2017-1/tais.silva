import java.util.ArrayList;

public class Constelacao {
    private String nome;
    //private Golpe[] golpes = new Golpe[3];
	private ArrayList golpes = new ArrayList();
    private int ultimaPosicaoPreenchida = 0;

    public Constelacao(String nome) {
        this.nome = nome;
    }    
    
    public void adicionarGolpe(Golpe golpe) {
        golpes[ultimaPosicaoPreenchida++] = golpe;        
    }
    
	public Golpe[] getGolpes() {
        return this.golpes;
    }
}