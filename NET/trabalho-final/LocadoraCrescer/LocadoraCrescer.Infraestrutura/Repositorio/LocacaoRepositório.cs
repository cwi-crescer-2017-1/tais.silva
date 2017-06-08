using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class LocacaoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public LocacaoRepositorio() { }

        public Locacao Obter(int id)
        {
            return contexto.Locacao.FirstOrDefault(u => u.Id.Equals(id));
        }

        public void Confirmar(Locacao locacao)
        {
            contexto.Locacao.Add(locacao);
            contexto.SaveChanges();
        }

        public void Devolver(Locacao atualizacao)
        {
            var antigo = Obter(atualizacao.Id);
            antigo.DataDevolucao = DateTime.Now;
            antigo.ValorFinal = atualizacao.ValorFinal;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
