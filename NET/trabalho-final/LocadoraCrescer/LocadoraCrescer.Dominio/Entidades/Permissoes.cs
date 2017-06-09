using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Permissoes
    {
        public int Id { get; set; }
        public string NomePermissoes { get; set; }

        protected Permissoes() { }
    }
}