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

    public void ordenar() {
        /*
         * BubbleSort
         * Complexidade: O(n^2)
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */

        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    }   

    public void ordenar(TipoOrdenacao tipo){
        boolean posicoesSendoTrocadas;
        TipoOrdenacao tipoAscendente = TipoOrdenacao.ASCENDENTE;
        TipoOrdenacao tipoDescendente = TipoOrdenacao.DESCENDENTE;

        if (tipoAscendente.equals(tipo)) {
            this.ordenar();
        }

        if (tipoDescendente.equals(tipo)) {
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < this.saints.size() - 1; i++) {
                    Saint atual = this.saints.get(i);
                    Saint proximo = this.saints.get(i + 1);
                    boolean precisaTrocar = atual.getVida() < proximo.getVida();
                    if (precisaTrocar) {
                        this.saints.set(i, proximo);
                        this.saints.set(i + 1, atual);
                        posicoesSendoTrocadas = true;
                    }
                }
            } while (posicoesSendoTrocadas); 
        }
    }

    public void addAllList(ArrayList<Saint> lista){
        this.saints.addAll(lista);
    }

    public ListaSaints unir(ArrayList<Saint> array) {
        ListaSaints novaLista = new ListaSaints();

        novaLista.addAllList(saints);
        novaLista.addAllList(array);
        return novaLista;	 	
    }

    public String getCSV() {
        String csv = new String();
        csv = csv = String.valueOf(this.get(0).getNome());

        for (int i=0; i < this.saints.size(); i++) {	        
            csv = String.valueOf(this.get(i).getNome()) + "," + String.valueOf(this.get(i).getVida()) + "," + String.valueOf(this.get(i).getArmadura().getConstelacao().getNome());
            /*csv = String.valueOf(this.get(i).getArmadura().getConstelacao());
            csv = String.valueOf(this.get(i).getStatus());
            csv = String.valueOf(this.get(i).getGenero());
            csv = String.valueOf(this.get(i).getArmaduraVestida());
            }*/

            return csv;
        }
        return csv;
    }
}