import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints {
    private ArrayList<Saint> saints = new ArrayList<Saint>();

    public void adicionar(Saint saint) {
        this.saints.add(saint);
    }

    public Saint get(int indice) {
        return this.saints.get(indice);
    }

    public ArrayList<Saint> todos() {
        return this.saints;
    }

    public void remover(Saint saint) {
        this.saints.remove(saint);
    }

    public Saint buscarPorNome(String nome) {
        // C#: foreach (Saint saint in this.saints) { }
        // Python: for saint in saints:
        // JavaScript: for (let saint of saints) { }
        /*for (Saint saint : this.saints) {
        if (saint.getNome().equals(nome)) {
        return saint;
        }
        }
        return null;*/
        return this.saints.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);
    }

    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        return (ArrayList<Saint>)this.saints.stream()
        .filter(s -> s.getArmadura().getCategoria().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>)this.saints.stream()
        .filter(s -> s.getStatus().equals(status))
        .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida() {

        if (saints.isEmpty()) {
            return null;
        }

        Saint maiorVida = this.saints.get(0);
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            boolean encontreiMaior = saint.getVida() > maiorVida.getVida();
            if (encontreiMaior) {
                maiorVida = saint;
            }
        }

        return maiorVida;
    }

    public Saint getSaintMenorVida() {

        if (saints.isEmpty()) {
            return null;
        }

        Saint menorVida = this.saints.get(0);
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            boolean encontreiMenor = saint.getVida() < menorVida.getVida();
            if (encontreiMenor) {
                menorVida = saint;
            }
        }

        return menorVida;
    }

    public void ordenar(TipoOrdenacao tipoOrdenacao) {
        /*
         * BubbleSort
         * Complexidade: O(n^2)
         * 
         * 
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = 
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();

                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }

    public void ordenar() {
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }

    public ListaSaints diff(ListaSaints listaSaints2) { 
        ListaSaints novaLista = new ListaSaints(); 

        for ( Saint saint : this.saints) { 
            boolean naoExisteNa2 = !listaSaints2.saints.contains(saint);       
            if (naoExisteNa2) { 
                novaLista.adicionar(saint); 
            } 
        }
        return novaLista;
    } 

    public int getSize() { 
        return this.saints.size(); 
    } 

    public ListaSaints intersec(ListaSaints listaSaints2){ 
        ListaSaints novaLista = new ListaSaints(); 

        for ( Saint saint : this.saints) { 
            boolean naoExisteNa2 = listaSaints2.saints.contains(saint);       
            if (naoExisteNa2) { 
                novaLista.adicionar(saint); 
            } 
        }       
        return novaLista; 
    } 

    public String getCSV() {
        if (this.saints.isEmpty()) {
            return "";
        }

        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);

        builder.append(this.saints.get(0).getCSV());
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            //resultado += separador + saint.getCSV();
            //builder.append(String.format("%s%s", separador, saint.getCSV()));
            builder.append(separador);
            builder.append(saint.getCSV());
        }

        return builder.toString();
    }

    /*@Override
    public String toString() {
    return String.valueOf(this.saints.size());
    }*/

}