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
    [RoutePrefix("api/Autores")]
	public class AutoresController : ApiController
	{
		private Contexto contexto = new Contexto();

		private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
		public IHttpActionResult ObterAutores()
		{
            var autores = repositorio.Obter();
            return Ok(new { dados = autores });
		}

		[Route("{id}")]
		[HttpGet]
		public IHttpActionResult ObterAutorPeloId(int id)
		{
            var autor = repositorio.Obter(id);
			return Ok( new { dados = autor }); 
		}

		[Route("{id:int}/Livros")]
		[HttpGet]
		public IHttpActionResult ObterLivrosDoAutor(int id)
		{
            var livros = repositorio.ObterLista(id);
			return Ok( new { dados = livros });
        }

        [HttpPost]
		public IHttpActionResult CriarAutor(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        [Route("{isbn:int}")]
        [HttpPut]
        public HttpResponseMessage AtualizarAutor(int id, Autor autor)
        {
            if (id != autor.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });
            }
            if (!repositorio.VerificarSeAutorExiste(id))
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                                    new { mensagens = new string[] { "Autor não encontrado" } });
            }

            repositorio.Atualizar(id, autor);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [Route("{id:int}")]
        [HttpDelete]
        public HttpResponseMessage DeletarAutor(int id)
        {
            var autor = repositorio.Obter(id);
            if (autor == null)
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { mensagens = new string[] { "Autor não encontrado" } });

            repositorio.Deletar(id);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }


}
