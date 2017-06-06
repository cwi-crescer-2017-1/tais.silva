using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class LocacaoExtra
    {
        public int IdLocacao { get; set; }
        public int IdExtra { get; set; }
        public int Quantidade { get; set; }

        public LocacaoExtra()
        { }
    }
}
