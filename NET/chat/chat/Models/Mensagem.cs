using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using chat.Controllers;
using chat.Models;

namespace chat.Models
{
    public class Mensagem
    {
        public int Id { get; private set; }
        public string Texto { get; set; }        
        public DateTime DateTimeEnvio { get; private set; }
        public Usuario Usuario { get; private set; }

        private static int contadorId = 0;

        public Mensagem(string texto, Usuario usuario)
        {
            this.Id = contadorId++;
            this.Texto = texto;            
            this.DateTimeEnvio = DateTime.Now;
            this.Usuario = usuario;
        }
    }
}