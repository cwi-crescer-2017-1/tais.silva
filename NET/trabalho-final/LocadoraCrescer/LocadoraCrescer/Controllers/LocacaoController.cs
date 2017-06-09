using System.Net.Http;
using System.Web.Http;
using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorio;
using System;
using LocadoraCrescer.Api.App_Start;
using System.Collections.Generic;

namespace LocadoraCrescer.Api.Controllers
{   
    [RoutePrefix("api/locacao")]
    public class LocacaoController : ControllerBasica
    {
        private LocacaoRepositorio repositorio = new LocacaoRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private UsuarioRepositorio repositorioUsuario = new UsuarioRepositorio();
        private ProdutoRepositorio repositorioProduto = new ProdutoRepositorio();
        private PacoteRepositorio repositorioPacote = new PacoteRepositorio();
        private ExtraRepositorio repositorioExtra = new ExtraRepositorio();

        [HttpPost, Route("orcamento")]
        public HttpResponseMessage Orcamento([FromBody]RegistrarLocacaoModel model)
        {
            var cliente = repositorioCliente.Obter(model.CpfCliente);
            var produto = repositorioProduto.Obter(model.IdProduto);
            var pacote = repositorioPacote.Obter(model.IdPacote);
            var extras = new List<Extra>();
            foreach (int id in model.IdExtras)
            {
                var extraAtual = repositorioExtra.Obter(id);
                extras.Add(extraAtual);
            }            
            var DataPedido = repositorio.DataAtual();
            var DataPrevista = repositorio.DataPrevista(pacote.Duracao); 

            var locacao = new Locacao(cliente, produto, pacote, extras, DataPedido, DataPrevista, model.ValorPrevisto);

            return ResponderOK(locacao);
        }

        [HttpGet, Route("lista")]
        public HttpResponseMessage ListaLocacoes()
        {            
            return ResponderOK(repositorio.ObterTodos());
        }

        [HttpGet, Route("lista")]
        public HttpResponseMessage ListaLocacoes(string cpf)
        {
            var cliente = repositorioCliente.Obter(cpf);
            return ResponderOK(repositorio.ObterPorCliente(cliente));
        }
        
        [Authorize(Roles = "Gerente")]
        [HttpPost, Route("relatorio")]
        public HttpResponseMessage RelatorioMensal(DateTime data)
        {
            var relatorio = repositorio.ObterFinalizadasUltimos30Dias(data);

            return ResponderOK(relatorio);
        }
        
        [Authorize(Roles = "Gerente")]
        [HttpGet, Route("atrasados")]
        public HttpResponseMessage RelatorioAtrasados()
        {
            var relatorio = repositorio.ObterAtrasados();

            return ResponderOK(relatorio);
        }

        [HttpPost, Route("confirmar")]
        public void Confirmar(Locacao locacao)
        {
            repositorio.Confirmar(locacao);
        }        

        [HttpPut]
        public HttpResponseMessage Devolver(Locacao atualizacao)
        {
            repositorio.Devolver(atualizacao);

            return ResponderOK();
        } 
    }
}