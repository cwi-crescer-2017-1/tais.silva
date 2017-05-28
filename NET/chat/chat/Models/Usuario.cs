using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chat.Models
{
    public class Usuario
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public string UrlImagemPerfil { get; set; }
        public DateTime DateTimeCadastro { get; private set; }

        private static int contadorId = 0;

        public Usuario(string nome, string url)
        {
            this.Id  = contadorId++;
            this.Nome = nome;
            this.UrlImagemPerfil = url;
            this.DateTimeCadastro = DateTime.Now;
        }
    }
}