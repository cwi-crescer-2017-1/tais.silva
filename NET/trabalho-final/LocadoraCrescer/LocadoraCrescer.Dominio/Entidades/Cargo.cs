using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cargo
    {
        public int Id { get; set; }
        public string NomeCargo { get; set; }

        protected Cargo() { }
    }
}