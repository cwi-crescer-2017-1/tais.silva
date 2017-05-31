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
    public class RevisoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        public IHttpActionResult Post(int id)
        {
            var revisores = repositorio.Criar();

            return Ok(revisores);
        }

        public IHttpActionResult Delete()
        {
            var revisores = repositorio.Deletar();

            return Ok(revisores);
        } 
    }
    

}
