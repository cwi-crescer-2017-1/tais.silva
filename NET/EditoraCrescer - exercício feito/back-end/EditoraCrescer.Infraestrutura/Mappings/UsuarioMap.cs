using EditoraCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraestrutura.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            HasMany(x => x.Permissoes).WithMany().Map(x =>
            {
                x.MapLeftKey("IdUsuario");
                x.MapRightKey("IdPermissao");
                x.ToTable("UsuarioPermissao");
            });
        }
    }
}
