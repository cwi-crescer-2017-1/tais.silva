using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        private static int contadorId = 0;
        private static List<Heroi> herois = new List<Heroi>();
        private static object objetoLock = new Object();
        
        public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            return herois.Where(x => 
                (id == null || x.Id == id) &&
                (nome == null || x.Nome == nome)
            );
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi.Id == 0)
            {
                //Salva no banco de dados :)
                lock (objetoLock)
                {
                    heroi.Id = contadorId++;
                    herois.Add(heroi);
                }                
                return Ok(heroi);
            }
            else
            {
                return BadRequest();
            }
        }
    }
}
