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
    [RoutePrefix("api/pacote")]
    public class PacoteController : ControllerBasica
    {
        private PacoteRepositorio repositorio = new PacoteRepositorio();
        
        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var pacote = repositorio.Obter(id);

            if (pacote == null)
                return ResponderErro("Pacote não encontrado.");

            return ResponderOK(new { Id = pacote.Id, Nome = pacote.Nome, Descricao = pacote.Descricao, Duracao = pacote.Duracao, Valor = pacote.Valor, Quantidade = pacote.Quantidade });
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            var pacotes = repositorio.Obter();

            if (pacotes == null)
                return ResponderErro("Pacotes não encontrado.");

            return ResponderOK(pacotes);
        }
    }
}