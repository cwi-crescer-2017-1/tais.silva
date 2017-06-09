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
        public string CpfCliente { get; set; }
        public string EmailUsuario { get; set; }
        public int IdProduto { get; set; }
        public int IdPacote { get; set; }
        public List<int> IdExtras { get; set; }
        public DateTime? DataPedido { get; set; }
        public DateTime? DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal? ValorFinal { get; set; }
    }
}