using LocadoraCrescer.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Web;
using System.Web.Http;
using LocadoraCrescer.Api.App_Start;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Api.Models;

namespace LocadoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ControllerBasica
    {
        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [BasicAuthorization]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { Usuario = usuario.Nome, Cargo = usuario.Cargo, Email = usuario.Email });
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarUsuarioModel model)
        {
            if (repositorio.Obter(model.Email) == null)
            {
                var usuario = new Usuario(model.Nome, model.Email, model.Senha, model.Cargo);

                if (usuario.Validar())
                {
                    repositorio.Criar(usuario);
                }
                else
                {
                    return ResponderErro(usuario.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }

            return ResponderOK();
        }
    }
}