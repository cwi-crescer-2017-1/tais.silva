using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class ProdutoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public ProdutoRepositorio() { }

        public Produto Obter(int id)
        {
            return contexto.Produto.Where(x => x.Id.Equals(id)).FirstOrDefault();
        }

        public List<Produto> Obter()
        {
            return contexto.Produto.ToList();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
