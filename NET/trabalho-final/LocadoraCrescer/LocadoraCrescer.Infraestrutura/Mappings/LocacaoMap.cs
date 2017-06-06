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
            HasMany(x => x.Extras)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdLocacao");
                    x.MapRightKey("IdExtra");
                    x.ToTable("LocacaoExtra");
                });
            HasKey(p => p.Pacote).HasRequired();
        }

    }

}
