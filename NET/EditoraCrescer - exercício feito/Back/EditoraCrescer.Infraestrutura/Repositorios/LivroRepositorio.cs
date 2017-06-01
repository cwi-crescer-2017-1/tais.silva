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

        //private Contexto contexto;
        //public LivroRepositorio()
        //{
        //    contexto = new Contexto();
        //}

        public object Obter()
        {
            var listaLivros =  contexto
                                .Livros
                                .Select(l => new
                                {
                                    Isbn = l.Isbn,
                                    Titulo = l.Titulo,
                                    Capa = l.Capa,
                                    NomeAutor = l.Autor.Nome,
                                    Genero = l.Genero
                                })
                                .ToList();

            return listaLivros;
        }

        public Livro Obter(int isbn)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);            
        }

        public object Obter(string genero)
        {  
            var listaLivros = contexto
                                .Livros
                                .Where(l => l.Genero.Contains(genero))
                                .Select(l => new
                                {
                                    Isbn = l.Isbn,
                                    Titulo = l.Titulo,
                                    Capa = l.Capa,
                                    NomeAutor = l.Autor.Nome,
                                    Genero = l.Genero
                                })
                                .ToList();

            return listaLivros;
        }

        public object ObterLancamentos()
        {
            var data7Dias = DateTime.Now.AddDays(-7); 
            var listaLivrosLancamentos = contexto
                                            .Livros
                                            .Where(l => l.DataPublicacao >= data7Dias)
                                            .Select(l => new
                                            {
                                                Isbn = l.Isbn,
                                                Titulo = l.Titulo,
                                                Capa = l.Capa,
                                                NomeAutor = l.Autor.Nome,
                                                Genero = l.Genero
                                            })
                                            .ToList();

            return listaLivrosLancamentos;
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
