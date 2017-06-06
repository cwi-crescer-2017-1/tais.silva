using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
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
