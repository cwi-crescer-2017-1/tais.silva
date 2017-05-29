using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using chat.Controllers;
using chat.Models;

namespace chat.Controllers
{
    public class UsuariosController : ApiController
    {
        public static List<Usuario> listaUsuarios = new List<Usuario>();
        private static int contadorId = 0;
        private static object @lock = new object();

        public List<Usuario> Get()
        {
            return listaUsuarios.OrderByDescending(u => u.Id).Take(5).ToList(); ;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    usuario.Id = contadorId++;
                    listaUsuarios.Add(usuario);
                }

                return Ok(usuario);
            }
        }        
    }
}