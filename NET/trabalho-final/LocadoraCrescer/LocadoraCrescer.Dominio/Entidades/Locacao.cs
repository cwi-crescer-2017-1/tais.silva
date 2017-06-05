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
        public Console Console { get; set; }
        public Pacote Pacote { get; set; }
        public List<Extra>  Extras { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }

        public Locacao()
        { }
    }
}
