using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class PacoteExtra
    {
        public int IdPacote { get; set; }
        public int IdExtra { get; set; }
        public int Quantidade { get; set; }

        public PacoteExtra()
        { }
    }
}
