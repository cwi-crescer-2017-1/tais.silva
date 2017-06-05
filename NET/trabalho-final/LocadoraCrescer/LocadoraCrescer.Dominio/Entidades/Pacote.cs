using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public int Duracao { get; set; }

        public Pacote()
        { }
    }
}
