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
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private Contexto contexto = new Contexto();

        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterTodosLivros()
        {
            var livros = repositorio.Obter();
            return Ok(new { dados = livros });
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorIsdn(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            return Ok(new { dados = livro });
        }

        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            var livro = repositorio.Obter(genero);
            return Ok(new { dados = livro });
        }

        [Route("lancamentos")]
        [HttpGet]
        public IHttpActionResult ObterLivrosDeLancamento()
        {
            var livros = repositorio.ObterLancamentos();
            return Ok(new { dados = livros });
        }        

        [HttpPost]
        public IHttpActionResult CriarLivro(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

        [Route("{isbn:int}")]
        [HttpPut]
        public HttpResponseMessage AtualizarLivro(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });
            }
            if (!repositorio.VerificarSeLivroExiste(isbn))
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                                    new { mensagens = new string[] { "Livro não encontrado" } });
            }

            repositorio.Atualizar(isbn, livro);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [Route("{isbn:int}")]
        [HttpDelete]
        public HttpResponseMessage DeletarLivro(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            if (livro == null)
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { mensagens = new string[] { "Livro não encontrado" } });

            repositorio.Deletar(isbn);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }


}
