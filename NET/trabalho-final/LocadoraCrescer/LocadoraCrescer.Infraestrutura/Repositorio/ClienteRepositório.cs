using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public ClienteRepositorio() { }

        public Cliente Obter(string cpf)
        {
            return contexto.Cliente.FirstOrDefault(u => u.Cpf.Equals(cpf));
        }        

        public void Criar(Cliente cliente)
        {
            contexto.Cliente.Add(cliente);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
