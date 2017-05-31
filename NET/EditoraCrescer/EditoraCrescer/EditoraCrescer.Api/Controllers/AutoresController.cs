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
    public class AutoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();

            return Ok(autores);
        }

        public IHttpActionResult Post(int id)
        {
            var autores = repositorio.Criar();

            return Ok(autores);
        }

        public IHttpActionResult Delete()
        {
            var autores = repositorio.Deletar();

            return Ok(autores);
        } 
    }
    

}
