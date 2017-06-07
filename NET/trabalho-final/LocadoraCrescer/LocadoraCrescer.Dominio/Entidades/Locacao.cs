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
        public Usuario Usuario { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Extra> Extras { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }

        protected Locacao() { }

        public Locacao(Cliente cliente, Usuario usuario, Produto produto, Pacote pacote, List<Extra> extra, DateTime dataPedido, DateTime dataPrevista, DateTime dataDevolucao, decimal valorPrevisto, decimal valorFinal)
        {
            Cliente = cliente;
            Usuario = usuario;
            Produto = produto;
            Pacote = pacote;
            Extras = extra;
            DataPedido = dataPedido;
            DataPrevista = dataPrevista;
            DataDevolucao = dataDevolucao;
            ValorPrevisto = valorPrevisto;
            ValorFinal = valorFinal;
        }
    }
}
