namespace EditoraCrescer.Infraestrutura.Migrations
{
    using EditoraCrescer.Dominio.Entidades;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<EditoraCrescer.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(EditoraCrescer.Infraestrutura.Contexto context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
            var usuario1 = new Usuario("Tais Jaques", "tais.silva@cwi.com.br", "123456");
            usuario1.AtribuirPermissoes("Revisor", "Publicador");
            context.Usuario.AddOrUpdate(usuario1);
        }
    }
}
