using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public PacoteRepositorio() { }

        public Pacote Obter(int id)
        {
            return contexto.Pacote.FirstOrDefault(x => x.Id.Equals(id));
        }

        public List<Pacote> Obter()
        {
            return contexto.Pacote.ToList();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
