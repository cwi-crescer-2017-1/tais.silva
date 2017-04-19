import java.util.ArrayList;

public class Constelacao {
    private String nome;
	private ArrayList golpes = new ArrayList<>();

    public Constelacao(String nome) {
        this.nome = nome;
    }    
    
    public void adicionarGolpe(Golpe golpe) {
        golpes.add(golpe);        
    }
    
	public ArrayList getGolpes() {
        return this.golpes;
    }
}