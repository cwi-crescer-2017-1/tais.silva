﻿using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            var listaLivros = new List<Livro>();

           // listaLivros.Select()

            return listaLivros;
        }

        public void Criar(Livro livro)
        {
            
            return contexto.Livros.Add(novoLivro);
        }

        public List<Livro> Deletar()
        {
            return contexto.Livros.ToList();
        }
    }
}
