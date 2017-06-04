namespace EditoraCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}