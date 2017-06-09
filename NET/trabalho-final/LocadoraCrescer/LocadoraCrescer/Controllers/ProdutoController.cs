using System.Net.Http;
using System.Web.Http;
using LocadoraCrescer.Api.App_Start;
using LocadoraCrescer.Infraestrutura.Repositorio;

namespace LocadoraCrescer.Api.Controllers
{
    [RoutePrefix("api/produto")]
    public class ProdutoController : ControllerBasica
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var produto = repositorio.Obter(id);

            if (produto == null)
                return ResponderErro("Produto não encontrado.");

            return ResponderOK(new { Id = produto.Id, Nome = produto.Nome, Valor = produto.Valor, Quantidade = produto.Quantidade });
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            var produtos = repositorio.Obter();

            if (produtos == null)
                return ResponderErro("Produtos não encontrado.");

            return ResponderOK(produtos);
        }
    }
}