using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio.Entidades;

namespace LocadoraCrescer.Dominio
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public int Cpf { get; set; }
        public Genero Genero { get; set; }
        public DateTime  DataNascimento { get; set; }
    }
}
