using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System.Collections.Generic;
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

        public IHttpActionResult Put(Produto produto)
        {
            var mensagens = new List<string>();

            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _produtoRepositorio.Alterar(produto);

            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            return Ok(_produtoRepositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_produtoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            _produtoRepositorio.Excluir(id);

            return Ok();
        }

    }
}
