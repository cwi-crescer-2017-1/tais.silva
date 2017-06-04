namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarBancoAtualizado : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Autores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Livros",
                c => new
                    {
                        Isbn = c.Int(nullable: false, identity: true),
                        Titulo = c.String(),
                        Descricao = c.String(),
                        Genero = c.String(),
                        DataPublicacao = c.DateTime(),
                        IdAutor = c.Int(nullable: false),
                        IdRevisor = c.Int(),
                        DataRevisao = c.DateTime(),
                        Capa = c.String(),
                    })
                .PrimaryKey(t => t.Isbn)
                .ForeignKey("dbo.Autores", t => t.IdAutor, cascadeDelete: true)
                .ForeignKey("dbo.Usuario", t => t.IdRevisor)
                .Index(t => t.IdAutor)
                .Index(t => t.IdRevisor);
            
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
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
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
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Usuario");
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Livros");
            DropTable("dbo.Autores");
        }
    }
}
