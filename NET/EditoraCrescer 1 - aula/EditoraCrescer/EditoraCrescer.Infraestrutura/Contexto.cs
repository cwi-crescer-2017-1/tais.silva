using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura
{
    public class Contexto : Context
    {
        public Contexto() : base("name=ExemploEFSP")
        { }

        public DbSet<Livro> Livros { get; set; }
        public DbSet<Livro> Autores { get; set; }
        public DbSet<Livro> Revisores { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new RevisorMap());
        }
    }
}
