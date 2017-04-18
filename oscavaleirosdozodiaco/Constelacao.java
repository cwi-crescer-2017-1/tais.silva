public class Constelacao {
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int indice;

    public Constelacao(String nome) {
        this.nome = nome;
    }

    public void adicionarGolpe(Golpe golpe) {
        //criar método que insere o golpe sempre no final do array
        for (int indice = -1; indice < golpes.length; indice++) {
            this.golpes[indice] = golpe;
        }
    }

    public Golpe[] getGolpes() {
        //método getGolpes para retornar o array de golpes
        return this.golpes;
    }

}