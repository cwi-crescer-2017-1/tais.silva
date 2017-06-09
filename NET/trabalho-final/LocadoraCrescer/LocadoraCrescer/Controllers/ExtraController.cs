using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Web;
using System.Web.Http;
using LocadoraCrescer.Api.App_Start;
using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio;
using LocadoraCrescer.Infraestrutura.Repositorio;

namespace LocadoraCrescer.Api.Controllers
{
    [RoutePrefix("api/extra")]
    public class ExtraController : ControllerBasica
    {
        private ExtraRepositorio repositorio = new ExtraRepositorio();
        
        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var extra = repositorio.Obter(id);

            if (extra == null)
                return ResponderErro("Extra não encontrado.");

            return ResponderOK(new { Id = extra.Id, Nome = extra.Nome, Valor = extra.Valor, Quantidade = extra.Quantidade });
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            var extras = repositorio.Obter();

            if (extras == null)
                return ResponderErro("Extras não encontrado.");

            return ResponderOK(extras);
        }
    }
}