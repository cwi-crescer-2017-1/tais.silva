using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer
{
    class Program
    {
        static void Main(string[] args)
        {
            var autor1 = new Autor() { Nome = "Tolkien" };
            var autor2 = new Autor() { Nome = "Machado de Assis" };

            using (var contexto = new Contexto())
            {
                //Inclusão
                contexto.Autores.Add(autor1);
                contexto.Autores.Add(autor2);
                contexto.SaveChanges();

                var livro = new Livro()
                {
                    Autor = autor1,
                    Titulo = "O senhor dos anéis",
                    Descricao = "Um livro bem legal",
                    Genero = "Aventura",
                    DataPublicacao = DateTime.Now
                };

                contexto.Livros.Add(livro);
            }
        }
    }
}
