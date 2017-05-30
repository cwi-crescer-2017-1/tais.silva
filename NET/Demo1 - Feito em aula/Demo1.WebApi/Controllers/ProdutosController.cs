using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class ProdutosController : ApiController
    {
        ProdutoRepositorio _produtoRepositorio = new ProdutoRepositorio();
        public IHttpActionResult Post(Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _produtoRepositorio.Criar(produto);

            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            var produtos = _produtoRepositorio.Listar();

            return Ok(produtos);
        }        
    }
}

