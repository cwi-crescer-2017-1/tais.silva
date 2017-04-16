
public class Batalha
{
    private int categoriaUm;
    private int categoriaDois;
    private Saint um;
    private Saint dois;

    public Batalha(Saint um, Saint dois)
    {
        this.categoriaUm = um.getValorDaCategoria();
        this.categoriaDois = dois.getValorDaCategoria();
        this.um = um;
        this.dois = dois;
    }

    //Retira 10.0 pontos do atributo vida do Saint que tiver a armadura menos valiosa em uma comparação/batalha entre dois Saints (OURO>PRATA>BRONZE).
    public void iniciar()
    {
        if (categoriaUm >= categoriaDois) {
            dois.setVida(dois.getVida() - 10);
        } else {
            um.setVida(um.getVida() - 10);
        }        
    }
}
