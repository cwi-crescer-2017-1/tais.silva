using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

		public Autor Obter(int id)
		{
			return contexto.Autores.FirstOrDefault(l => l.Id == id);
		}

		public List<Livro> ObterLista(int id)
		{
			return contexto.Livros.Where(l => l.IdAutor == id).ToList();
		}

		public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var primeiroId = contexto.Autores.FirstOrDefault(r => r.Id == id);
            if (primeiroId != null)
            {
                contexto.Autores.Remove(primeiroId);
                contexto.SaveChanges();
            }
        }

		public void Atualizar(int id, Autor autor)
		{
			var autorAnterior = contexto.Autores.FirstOrDefault(r => r.Id == id);
			if (autorAnterior != null)
			{
				autorAnterior = autor;
				contexto.Entry(autorAnterior).State = EntityState.Modified;
				contexto.SaveChanges();
			}
		}

        public bool VerificarSeAutorExiste(int id)
        {
            return contexto.Autores.Count(a => a.Id == id) > 0;
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }        
    }
}
