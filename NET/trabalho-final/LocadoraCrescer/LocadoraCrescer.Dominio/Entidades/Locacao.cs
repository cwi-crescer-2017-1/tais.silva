using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public Funcionario Funcionario { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public LocacaoExtra IdLocacaoExtra { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }

        protected Locacao() { }

        public Locacao(int id, Cliente cliente, Funcionario funcionario, Produto produto, Pacote pacote, LocacaoExtra idLocacaoExtra, DateTime dataPedido, DateTime dataPrevista, DateTime? dataDevolucao, decimal valorPrevisto, decimal valorFinal)
        {
            Id = id;
            Cliente = cliente;
            Funcionario = funcionario;
            Produto = produto;
            Pacote = pacote;
            IdLocacaoExtra = idLocacaoExtra;
            DataPedido = dataPedido;
            DataPrevista = dataPrevista;
            DataDevolucao = dataDevolucao;
            ValorPrevisto = valorPrevisto;
            ValorFinal = valorFinal;
        }
    }
}
