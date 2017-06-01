using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

		public Revisor Obter(int id)
		{
			return contexto.Revisores.FirstOrDefault(l => l.Id == id);
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
		
		public void Atualizar(int id, Revisor revisor)
		{
			var revisorAnterior = contexto.Revisores.FirstOrDefault(r => r.Id == id);
			if (revisorAnterior != null)
			{
				revisorAnterior = revisor;
				contexto.Entry(revisorAnterior).State = EntityState.Modified;
				contexto.SaveChanges();
			}
		}

        public bool VerificarSeRevisorExiste(int id)
        {
            return contexto.Revisores.Count(r => r.Id == id) > 0;
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}