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
    public class LivrosController : ApiController
    {
        private Contexto contexto = new Contexto();

        private LivroRepositorio repositorio = new LivroRepositorio();

        public List<Livro> Get()
        {
            return repositorio.Obter();
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }


}
