using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Autores.ToList();
        }

        public List<Livro> Criar()
        {
            return contexto.Autores.ToList();
        }

        public List<Livro> Deletar()
        {
            return contexto.Autores.ToList();
        }
    }
}
