namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class modificarClasses : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Funcionario");
            CreateTable(
                "dbo.Cargo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCargo = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                        Cargo_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cargo", t => t.Cargo_Id)
                .Index(t => t.Cargo_Id);
            
            AddColumn("dbo.Pacote", "Descricao", c => c.String());
            AddForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Usuario", "Id", cascadeDelete: true);
            DropColumn("dbo.Pacote", "Descirção");
            DropTable("dbo.Funcionario");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Funcionario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                        Cargo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Pacote", "Descirção", c => c.String());
            DropForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Usuario");
            DropForeignKey("dbo.Usuario", "Cargo_Id", "dbo.Cargo");
            DropIndex("dbo.Usuario", new[] { "Cargo_Id" });
            DropColumn("dbo.Pacote", "Descricao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Cargo");
            AddForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Funcionario", "Id", cascadeDelete: true);
        }
    }
}
