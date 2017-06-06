using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio.Entidades;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class LocacaoExtraMap : EntityTypeConfiguration<LocacaoExtra>
    {
        public LocacaoExtraMap()
        {
            ToTable("Pacote");
            HasMany(x => x.Extras)
                .WithMany()
                .Map(x =>
            {
                x.MapLeftKey("IdPacote");
                x.MapRightKey("IdExtra");
                x.ToTable("PacoteExtra");
            });
        }
        
    }
}
