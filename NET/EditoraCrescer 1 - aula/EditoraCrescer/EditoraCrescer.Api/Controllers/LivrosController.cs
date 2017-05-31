using EditoraCrescer.Infraestrutura;
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

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }

        public IHttpActionResult Post(int id)
        {
            var livros = repositorio.Criar();

            return Ok(livros);
        }

        public IHttpActionResult Delete()
        {
            var livros = repositorio.Deletar();

            return Ok(livros);
        } 
    }
    

}
