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
			return Ok(repositorio.Obter());
		}

		[Route("{id}")]
		[HttpGet]
		public IHttpActionResult ObterAutorPeloId(int id)
		{
			return Ok(repositorio.Obter(id));
		}

		[Route("{id:int}/Livros")]
		[HttpGet]
		public IHttpActionResult ObterLivrosDoAutor(int id)
		{
			return Ok(repositorio.ObterLista(id));
		}

		public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult DeletarAutor(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }


}
