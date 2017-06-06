using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraCrescer.Dominio.Entidades;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    class PacoteExtraMap : EntityTypeConfiguration<PacoteExtra>
    {
        public PacoteExtraMap()
        {
            ToTable("PacoteExtra");

            HasRequired(x => x.IdExtra);

            HasRequired(x => x.IdPacote);
        }
    }
}
