using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using LocadoraCrescer.Dominio;
using LocadoraCrescer.Dominio.Entidades;

namespace LocadoraCrescer.Api.Models
{
    public class RegistrarLocacaoModel
    {
        public string cpfCliente { get; set; }
        public string emailUsuario { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Extra> Extras { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }
    }
}