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
            var valorOrcamento = repositorio.valorLocacao(model.IdProduto, model.IdPacote, model.IdExtras);

            model.ValorPrevisto = valorOrcamento;

            return ResponderOK(new { CpfCliente = model.CpfCliente, IdProduto = model.IdProduto, IdPacote = model.IdPacote, IdExtras = model.IdExtras, ValorPrevisto = model.ValorPrevisto });
        }

        [HttpPost, Route("confirmar")]
        public HttpResponseMessage Confirmar([FromBody]RegistrarLocacaoModel model)
        {
            var novaModel = repositorio.ObterOrcamento(model.CpfCliente, model.IdProduto, model.IdPacote, model.IdExtras, model.ValorPrevisto);

            var locacao = new Locacao(novaModel.Cliente, novaModel.Produto, novaModel.Pacote, novaModel.Extras, novaModel.DataPedido, novaModel.DataPrevista, novaModel.ValorPrevisto);

            repositorio.Confirmar(locacao);

            return ResponderOK(locacao);
        }        

        [HttpPut]
        public HttpResponseMessage Devolver(Locacao atualizacao)
        {
            repositorio.Devolver(atualizacao);

            return ResponderOK();
        } 

        [HttpGet, Route("lista")]
        public HttpResponseMessage ListaLocacoes()
        {            
            return ResponderOK(repositorio.ObterTodos());
        }

        [HttpGet, Route("listacpf/{cpf}")]
        public HttpResponseMessage ListaLocacoes(string cpf)
        {
            var cliente = repositorioCliente.Obter(cpf);
            var lista = repositorio.ObterPorCliente(cliente);
            return ResponderOK(lista);
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
    }
}