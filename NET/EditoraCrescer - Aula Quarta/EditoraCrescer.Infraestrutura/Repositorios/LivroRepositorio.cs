using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable 
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro Obter(int isbn)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);            
        }

        public List<Livro> Obter(string genero)
        {  
            return contexto.Livros.Where(l => l.Genero.Contains(genero)).ToList();
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Deletar(int isbn)
        {
            var primeiroId = contexto.Livros.FirstOrDefault(r => r.Isbn == isbn);
            if (primeiroId != null)
            {
                contexto.Livros.Remove(primeiroId);
                contexto.SaveChanges();
            }
        }

        public void Atualizar(int isbn, Livro livro)
        {
            var livroAnterior = contexto.Livros.FirstOrDefault(r => r.Isbn == isbn);
            if (livroAnterior != null)
            {
                livroAnterior = livro;
                contexto.Entry(livroAnterior).State = EntityState.Modified;
                contexto.SaveChanges();
            }
        }

        public bool VerificarSeLivroExiste(int isbn)
        {
            return contexto.Livros.Count(e => e.Isbn == isbn) > 0;
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }

        
    }
}
