public class Jogo {

    private static void imprimeInterno(String[] args) {
        System.out.println(args[0]);
    }

    private static void imprimirArgumentos(String[] args) throws Exception {
        try {
            imprimeInterno(args);
        } catch (ArrayIndexOutOfBoundsException erroIndice) {
            System.out.println("Ops.. verifique os argumentos!");
            throw new Exception(erroIndice);
        } catch (Exception e) {
            // TODO: fazer algo....
            System.out.println(":(");
            e.printStackTrace();
        } finally {
            System.out.println("terminou imprimirArgumentos");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando o jogo...");
            System.out.println("EA sports... It's in the game");
            Jogo.imprimirArgumentos(args);
        } catch (Exception e) {
            System.out.println("Erro no jogo: " + e);
            e.printStackTrace();
        }
    }
}