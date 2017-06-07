using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorio;

namespace LocadoraCrescer.Api.Controllers
{
    public class LocacaoController : ApiController
    {
        private LocacaoRepositorio repositorio = new LocacaoRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private UsuarioRepositorio repositorioUsuario = new UsuarioRepositorio();

        // GET api/<controller>
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/<controller>/5
        public string Get(int id)
        {
            return "value";
        }

        public string cpfCliente { get; set; }
        public string emailUsuario { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Extra> Extras { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataPrevista { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }

        [HttpGet]
        public void Orcamento([FromBody]RegistrarLocacaoModel model)
        {
            var cliente = repositorioCliente.Obter(model.cpfCliente);
            var usuario = repositorioUsuario.Obter(model.emailUsuario);
            var produto = repositorioUsuario.Obter(model.emailUsuario);
            var pacote = repositorioUsuario.Obter(model.emailUsuario);

            var locacao = new Locacao(cliente, usuario, produto, pacote);

            repositorio.Salvar(locacao);
        }

        [HttpPost]
        public void Post([FromBody]RegistrarLocacaoModel model)
        {

        }

            // PUT api/<controller>/5
            public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
        }
    }
}