namespace EditoraCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}