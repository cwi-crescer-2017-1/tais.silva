using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");
            HasRequired(x => x.Cliente).WithMany().Map(x => x.MapKey("IdCliente"));
            HasRequired(x => x.Funcionario).WithMany().Map(x => x.MapKey("IdFuncionario"));
            HasRequired(x => x.Produto).WithMany().Map(x => x.MapKey("IdProduto"));
            HasOptional(x => x.Pacote).WithMany().Map(x => x.MapKey("IdPacote"));
            HasMany(x => x.Extras)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdLocacao");
                    x.MapLeftKey("IdExtra");
                    x.ToTable("LocacaoExtra");
                });
            
        }

    }

}
