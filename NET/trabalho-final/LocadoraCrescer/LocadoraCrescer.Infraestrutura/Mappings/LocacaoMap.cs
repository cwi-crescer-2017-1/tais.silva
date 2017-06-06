using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public LocacaoMap() : EntityTypeConfiguration<Locacao>
    {
        ToTable("Locacao");

        HasRequired(x => x.Extras)
            .WithMany()
            .HasForeignKey(x => x.Extras);
    }
}
