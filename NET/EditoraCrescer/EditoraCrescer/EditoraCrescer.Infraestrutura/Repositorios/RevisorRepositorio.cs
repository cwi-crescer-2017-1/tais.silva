using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public List<Livro> Criar()
        {
            return contexto.Revisores.ToList();
        }

        public List<Livro> Deletar()
        {
            return contexto.Revisores.ToList();
        }
    }
}
