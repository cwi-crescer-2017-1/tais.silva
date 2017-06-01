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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
           return Ok(repositorio.Obter());
        }

        [Route("{id:int}")]
        [HttpGet]
        public IHttpActionResult ObterRevisorPorId(int id)
        {
            return Ok(repositorio.Obter(id));
        }

        [HttpPost]
        public IHttpActionResult CriarRevisor(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok();
        }

        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

        [Route("{id:int}")]
        [HttpPut]
        public IHttpActionResult AtualizarRevisor(int id, Revisor revisor)
        {
            repositorio.Atualizar(id, revisor);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
    

}
