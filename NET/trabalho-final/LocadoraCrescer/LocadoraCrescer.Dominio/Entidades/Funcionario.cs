using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public Cargo Cargo { get; set; }

        protected Usuario() { }

        public Usuario(string nome, string email, string senha, Cargo cargo)
        {
            string Nome = nome;
            string Email = email;
            string Senha = senha;
            Cargo Cargo = cargo;
        }

        public void Alterar(string nome, string email, string senha, Cargo cargo)
        {
            string Nome = nome;
            string Email = email;
            string Senha = senha;
            Cargo Cargo = cargo;
        }
    }
}
