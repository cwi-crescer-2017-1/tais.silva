public class SorteDoDia {
    private Sorteador sorteador; 
    public SorteDoDia(Sorteador sorteador) { 
        this.sorteador = sorteador; 
    }
 
    public boolean estouComSorte() { 
        int resultado = this.sorteador.sortear(); 
        return resultado % 2 == 0; 
    }   
 
}