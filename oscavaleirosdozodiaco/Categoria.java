public enum Categoria
{
    OURO(3), PRATA(2), BRONZE(1);
    
    private int valorCategoria;
    
    private Categoria(int valor) {
        this.valorCategoria = valor;
    }
    
    public int getValor() {
        return this.valorCategoria;
    }
}
