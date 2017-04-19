import java.util.ArrayList;
//import java.util.AbstractCollection;
import java.util.*;

public class ListaSaints
{    
    private ArrayList<Saint> arrayLista = new ArrayList<>();
    private Saint saint;

    public ListaSaints(Saint Saint)
    {
        this.saint = saint;
    }

    public void adicionar(Saint saint)
    {
        this.arrayLista.add(saint);
    }

    public Saint get(int indice) {
        return arrayLista.get(indice);
    }

    public ArrayList todos() {
        return this.arrayLista;
    }

    public void remover(Saint saint) {
        int index = this.arrayLista.indexOf(saint);
        this.arrayLista.remove(index);
    }

    public String buscarPorNome(String nome) {
        int index = arrayLista.indexOf(nome);
        return arrayLista.get(index).toString();
    }

    public ArrayList buscarPorCategoria(Categoria categoria) {
        ArrayList<Saint> subLista = new ArrayList<>();
        
        for (int i = 0; i < arrayLista.size(); i++){
            Saint nomeSaint = this.arrayLista.get(i);
            if (nomeSaint.getCategoria() == categoria) {
                subLista.add(nomeSaint);
            }
        }
        
        return subLista;
    }
    
    public ArrayList buscarPorStatus(Status status){
        ArrayList<Saint> subLista = new ArrayList<>();
        
        for (int i = 0; i < arrayLista.size(); i++){
            Saint nomeSaint = this.arrayLista.get(i);
            if (nomeSaint.getStatus() == status) {
                subLista.add(nomeSaint);
            }
        }
        
        return subLista;
    }
    
    public Saint getSaintMaiorVida(){
        Saint nomeSaintDeMaiorVida = this.arrayLista.get(0);
        
        for (int i = 0; i < arrayLista.size(); i++){
            Saint nomeSaint = this.arrayLista.get(i);
            double maiorVida = this.arrayLista.get(0).getVida();
            Saint saintMaiorVida = nomeSaint;
            if (nomeSaint.getVida() > maiorVida) {
                maiorVida = nomeSaint.getVida();
                nomeSaintDeMaiorVida = nomeSaint;
            }
        }
        
        return nomeSaintDeMaiorVida;
    }
    
    public Saint getSaintMenorVida(){
        Saint nomeSaintDeMenorVida = this.arrayLista.get(0);
        
        for (int i = 0; i < arrayLista.size(); i++){
            Saint nomeSaint = this.arrayLista.get(i);
            double menorVida = this.arrayLista.get(0).getVida();
            Saint saintMenorVida = nomeSaint;
            if (nomeSaint.getVida() < menorVida) {
                menorVida = nomeSaint.getVida();
                nomeSaintDeMenorVida = nomeSaint;
            }
        }
        
        return nomeSaintDeMenorVida;
    }
    
    /*public void ordenar() {
        Saint nomeSaintDeMenorVida = this.arrayLista.get(0);
        
        for (int i = 0; i < arrayLista.size(); i++){
            Saint nomeSaint = this.arrayLista.get(i);
            double menorVida = this.arrayLista.get(0).getVida();
            Saint saintMenorVida = nomeSaint;
            if (nomeSaint.getVida() < menorVida) {
                menorVida = nomeSaint.getVida();
                nomeSaintDeMenorVida = nomeSaint;
            }
        }
        
        return nomeSaintDeMenorVida;
    }*/
    
}
