using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using chat.Models;
using chat.Controllers;
using System.Text.RegularExpressions;

namespace chat.Controllers
{
    public class MensagensController : ApiController
    {
        public static List<Mensagem> listaMensagens = new List<Mensagem>();
        private static int contadorId = 0;
        private static object @lock = new object();

        public List<Mensagem> Get()
        {
            return listaMensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    mensagem.Id = contadorId++;
                    mensagem.Texto = mensagem.Texto.Replace("André Nunes", "$$$$$ $$$$$");
                    listaMensagens.Add(mensagem);
                }
                return Ok(listaMensagens);
            }
        }
    }
}
