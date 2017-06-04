namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class acrescentarPermissoes : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Revisores", newName: "Permissao");
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime());
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime(nullable: false));
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            RenameTable(name: "dbo.Permissao", newName: "Revisores");
        }
    }
}
