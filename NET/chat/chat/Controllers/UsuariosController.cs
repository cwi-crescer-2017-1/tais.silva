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

        public List<Usuario> Get()
        {
            return listaUsuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            listaUsuarios.Add(usuario);
            return Ok(listaUsuarios);
        }        
    }
}