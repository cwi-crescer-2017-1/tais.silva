using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var primeiroId = contexto.Autores.FirstOrDefault(r => r.Id == id);
            if (primeiroId != null)
            {
                contexto.Autores.Remove(primeiroId);
                contexto.SaveChanges();
            }
        }
    }
}
