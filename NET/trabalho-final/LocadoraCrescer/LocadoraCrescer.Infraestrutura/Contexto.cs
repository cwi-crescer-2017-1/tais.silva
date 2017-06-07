using LocadoraCrescer.Dominio;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("Locadora")
        { }

        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Produto> Produto { get; set; }
        public DbSet<Locacao> Locacao { get; set; }
        public DbSet<Pacote> Pacote { get; set; }
        public DbSet<Extra> Extra { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}
