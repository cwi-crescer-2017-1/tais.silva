using EditoraCrescer.WebApi;
using EditoraCrescer.WebApi.Controllers;
using System;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace AutDemo.WebApi.Controllers
{

    public class ExemploController : ControllerBasica
    {
        public ExemploController()
        {
            
        }

        [HttpGet, BasicAuthorization(Roles = "Administrador")]
        public HttpResponseMessage Get(string nome)
        {
            if (nome == "nunes")
            {
                throw new Exception("Não é possível usar o nome nunes. Tenha cuidado da próxima vez.");
            }

            return ResponderOK($"Acesso anônimo permitido. Usuário logado é {Thread.CurrentPrincipal.Identity.Name}");
        }

        [HttpGet]
        public HttpResponseMessage Get(int id)
        {
            return ResponderOK($"Qualquer usuário autenticado pode acessar. Usuário logado é {Thread.CurrentPrincipal.Identity.Name}");
        }

        [HttpGet, BasicAuthorization(Roles = "Administrador")]
        public HttpResponseMessage Get()
        {
            return ResponderOK($"Somente usuários do grupo Administradores podem acessar. Usuário logado é {Thread.CurrentPrincipal.Identity.Name}");
        }
    }
}