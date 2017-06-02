using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using EditoraCrescer.Api.App_Start;

namespace EditoraCrescer.Api.Controllers
{
    public class TesteController : ApiController
    {   
        [MinhaAutenticacao(Roles = "Publicador")]
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(System.Net.HttpStatusCode.OK);
        }
    }
}