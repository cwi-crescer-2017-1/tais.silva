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

        public Locacao ObterOrcamento(string CpfCliente, int IdProduto, int IdPacote, List<int> IdExtras, decimal ValorPrevisto)
        {
            var cliente = contexto.Cliente.FirstOrDefault(x => x.Cpf.Equals(CpfCliente));
            var produto = contexto.Produto.FirstOrDefault(x => x.Id.Equals(IdProduto));
            var pacote = contexto.Pacote.FirstOrDefault(x => x.Id.Equals(IdPacote));
            var extras = new List<Extra>();
            foreach (int id in IdExtras)
            {
                var extraAtual = contexto.Extra.FirstOrDefault(x => x.Id.Equals(id));
                extras.Add(extraAtual);
            }
            var DataPedido = DateTime.Now;
            var DataPrevista = DateTime.Now.AddDays(pacote.Duracao);

            var novaModel = new Locacao(cliente, produto, pacote, extras, DataPedido, DataPrevista, ValorPrevisto);

            return novaModel;
        }

        public List<Locacao> ObterTodos()
        {
            return contexto.Locacao.ToList();
        }

        public List<Locacao> ObterPorCliente(Cliente cliente)
        {
            return contexto.Locacao.Where(x => x.Cliente.Id.Equals(cliente.Id)).ToList();
        }

        public DateTime DataAtual()
        {
            return DateTime.Now;
        }

        public DateTime DataPrevista(int duracao)
        {
            return DateTime.Now.AddDays(duracao);
        }

        public Locacao Confirmar(Locacao locacao)
        {
            contexto.Locacao.Add(locacao);
            contexto.SaveChanges();
            return locacao;
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
