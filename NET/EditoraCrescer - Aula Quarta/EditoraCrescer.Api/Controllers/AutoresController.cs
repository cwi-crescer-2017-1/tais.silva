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
	public class AutoresController : ApiController
	{
		private Contexto contexto = new Contexto();

		private AutorRepositorio repositorio = new AutorRepositorio();

		[Route("{id}")]
		[HttpGet]
		public List<Autor> ObterAutores()
		{
			return repositorio.Obter();
		}

		[Route("{id}")]
		[HttpGet]
		public Autor ObterAutorPeloId(int id)
		{
			return repositorio.Obter(id);
		}

		[Route("{id:int}/Livros")]
		[HttpGet]
		public List<Livro> ObterLivrosDoAutor(int id)
		{
			return repositorio.ObterLista(id);
		}

		public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
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
