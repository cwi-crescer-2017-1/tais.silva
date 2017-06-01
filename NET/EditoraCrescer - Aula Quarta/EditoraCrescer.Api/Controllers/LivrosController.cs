using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private Contexto contexto = new Contexto();

        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterTodosLivros()
        {
            return Ok(repositorio.Obter());
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorIsdn(int isbn)
        {
            return Ok(repositorio.Obter(isbn));
        }

        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            return Ok(repositorio.Obter(genero));
        }

        [HttpPost]
        public IHttpActionResult CriarLivro(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

        [Route("{isbn:int}")]
        [HttpPut]
        public IHttpActionResult AtualizarLivro(int isbn, Livro livro)
        {
            repositorio.Atualizar(isbn, livro);
            return Ok();
        }

        [Route("{isbn:int}")]
        [HttpDelete]
        public IHttpActionResult DeletarLivro(int isbn)
        {
            repositorio.Deletar(isbn);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }


}
