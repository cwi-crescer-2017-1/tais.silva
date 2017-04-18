public class Constelacao {
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int ultimaPosicaoPreenchida = 0;

    public Constelacao(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Golpe[] getGolpes() {
        return this.golpes;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes[ultimaPosicaoPreenchida++] = golpe;        
    }
    
}