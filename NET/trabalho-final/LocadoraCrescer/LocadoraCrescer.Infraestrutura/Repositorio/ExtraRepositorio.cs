using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class ExtraRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public ExtraRepositorio() { }

        public Extra Obter(int id)
        {
            return contexto.Extra.Where(x => x.Id.Equals(id)).FirstOrDefault();
        }

        public List<Extra> Obter()
        {
            return contexto.Extra.ToList();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
