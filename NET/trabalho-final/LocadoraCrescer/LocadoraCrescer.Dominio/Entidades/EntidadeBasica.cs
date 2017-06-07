using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public abstract class EntidadeBasica
    {
        public List<string> Mensagens { get; private set; }

        public EntidadeBasica()
        {
            Mensagens = new List<string>();
        }

        public abstract bool Validar();
    }
}
