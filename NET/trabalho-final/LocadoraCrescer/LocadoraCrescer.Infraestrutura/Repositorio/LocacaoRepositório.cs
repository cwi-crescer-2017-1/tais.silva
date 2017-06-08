using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio;
using System.Data.Entity;

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

        public List<Locacao> ObterTodos()
        {
            return contexto.Locacao.ToList();
        }

        public List<Locacao> ObterPorCliente(Cliente cliente)
        {
            return contexto.Locacao.Where(x => x.Cliente.Equals(cliente)).ToList();
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
            contexto.Entry(antigo).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public List<Locacao> ObterFinalizadasUltimos30Dias(DateTime data)
        {
            var data30Dias = data.AddDays(-30).Date;
            return contexto.Locacao.Where(l => l.DataDevolucao != null && l.DataDevolucao >= data30Dias && l.DataDevolucao <= data).ToList();
        }

        public List<Locacao> ObterAtrasados()
        {
            return contexto.Locacao.Where(l => l.DataDevolucao == null && l.DataDevolucao > l.DataPrevista).ToList();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
