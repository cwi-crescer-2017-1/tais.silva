using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorio
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio() { }

        public Usuario Obter(string email)
        {
            return contexto.Usuario.Include("Permissoes").FirstOrDefault(u => u.Email.Equals(email));
        }

        public void Criar(Usuario usuario)
        {
            contexto.Usuario.Add(usuario);
            contexto.Entry(usuario.Permissoes).State = System.Data.Entity.EntityState.Unchanged;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
