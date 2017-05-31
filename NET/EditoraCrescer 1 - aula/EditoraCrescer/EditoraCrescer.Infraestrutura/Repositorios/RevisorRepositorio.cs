using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var primeiroId = contexto.Revisores.FirstOrDefault(r => r.Id == id);
            if (primeiroId != null)
            {
                contexto.Revisores.Remove(primeiroId);
                contexto.SaveChanges();
            }
        }
    }
