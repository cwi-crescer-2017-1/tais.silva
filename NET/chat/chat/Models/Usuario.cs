using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chat.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string UrlImagemPerfil { get; set; }

        public Usuario(string nome, string url)
        {
            this.Nome = Nome;
            this.UrlImagemPerfil = url;
        }
    }
}