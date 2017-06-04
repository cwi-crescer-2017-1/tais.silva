using EditoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            contexto.Usuario.Add(usuario);
            contexto.SaveChanges();
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(Usuario usuario)
        {
            contexto.Usuario.Remove(usuario);
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuario.ToList();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuario.Include("Permissoes").FirstOrDefault(u => u.Email.Equals(email));
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
