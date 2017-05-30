using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();

            if (!pedido.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
            var mensagens = new List<string>();

            if (!pedido.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _pedidoRepositorio.Alterar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Get()
        {
            return Ok(_pedidoRepositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);

            return Ok();
        }
    }
}