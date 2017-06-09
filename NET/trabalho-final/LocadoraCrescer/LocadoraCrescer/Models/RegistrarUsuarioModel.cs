using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using LocadoraCrescer.Dominio.Entidades;

namespace LocadoraCrescer.Api.Models
{
    public class RegistrarUsuarioModel
    {
        public string Email { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
        public Permissoes Permissoes { get; set; }
    }
}