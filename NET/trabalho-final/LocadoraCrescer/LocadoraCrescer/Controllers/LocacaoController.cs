using System.Net.Http;
using System.Web.Http;
using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorio;

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
        
        [HttpGet]
        public HttpResponseMessage Orcamento([FromBody]RegistrarLocacaoModel model)
        {
            var cliente = repositorioCliente.Obter(model.CpfCliente);
            var usuario = repositorioUsuario.Obter(model.EmailUsuario);
            var produto = repositorioProduto.Obter(model.IdProduto);
            var pacote = repositorioPacote.Obter(model.IdPacote);

            var locacao = new Locacao(cliente, usuario, produto, pacote, model.Extras, model.DataPedido, model.DataPrevista, model.ValorPrevisto);

            return ResponderOK(locacao);
        }

        [HttpPost]
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