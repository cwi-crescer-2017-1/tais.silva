using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chat.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string Texto { get; set; }
        public Usuario Usuario { get; private set; }
        public DateTime DateTime { get; private set; }

        public Mensagem(string texto, Usuario usuario)
        {
            this.Texto = texto;
            this.Usuario = usuario;
            this.DateTime = DateTime.Now;
        }
    }
}