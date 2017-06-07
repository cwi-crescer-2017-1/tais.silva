using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Web;
using System.Web.Http;
using LocadoraCrescer.Api.App_Start;
using LocadoraCrescer.Dominio;
using LocadoraCrescer.Infraestrutura.Repositorio;

namespace LocadoraCrescer.Api.Controllers
{
    [RoutePrefix("api/acessos")]
    public class ClienteController : ControllerBasica
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [BasicAuthorization]
        [HttpGet, Route("cliente")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var cliente = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (cliente == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { Cliente = cliente.Nome, Endereco = cliente.Endereco, Cpf = cliente.Cpf, Genero = cliente.Genero, DataNascimento = cliente.DataNascimento });
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar(Cliente novoCliente)
        {
            if (repositorio.Obter(novoCliente.Cpf) == null)
            {
                var cliente = new Cliente(novoCliente.Nome, novoCliente.Endereco, novoCliente.Cpf, novoCliente.Genero, novoCliente.DataNascimento);

                if (cliente.Validar())
                {
                    repositorio.Criar(cliente);
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Cliente já existe.");
            }

            return ResponderOK();
        }
    }
}