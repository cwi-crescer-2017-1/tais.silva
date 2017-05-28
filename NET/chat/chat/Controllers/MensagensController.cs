using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using chat.Models;
using chat.Controllers;

namespace chat.Controllers
{
    public class MensagensController : ApiController
    {
        public static List<Mensagem> listaMensagens = new List<Mensagem>();

        public List<Mensagem> Get()
        {
            return listaMensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            mensagem.Texto = mensagem.Texto.Replace("André Nunes", "$$$$$ $$$$$");
            
            listaMensagens.Add(mensagem);
            return Ok(mensagem);
        }

    }
}
