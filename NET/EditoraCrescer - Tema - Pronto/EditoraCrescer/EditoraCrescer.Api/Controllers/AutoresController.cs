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

        public List<Autor> Get()
        {
            return repositorio.Obter();
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
    }


}
