namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alterarCargoParaPermissoes : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Usuario", "IdCargo", "dbo.Cargo");
            DropIndex("dbo.Usuario", new[] { "IdCargo" });
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomePermissoes = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Usuario", "IdPermissoes", c => c.Int(nullable: false));
            CreateIndex("dbo.Usuario", "IdPermissoes");
            AddForeignKey("dbo.Usuario", "IdPermissoes", "dbo.Permissoes", "Id", cascadeDelete: true);
            DropColumn("dbo.Usuario", "IdCargo");
            DropTable("dbo.Cargo");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Cargo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCargo = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Usuario", "IdCargo", c => c.Int(nullable: false));
            DropForeignKey("dbo.Usuario", "IdPermissoes", "dbo.Permissoes");
            DropIndex("dbo.Usuario", new[] { "IdPermissoes" });
            DropColumn("dbo.Usuario", "IdPermissoes");
            DropTable("dbo.Permissoes");
            CreateIndex("dbo.Usuario", "IdCargo");
            AddForeignKey("dbo.Usuario", "IdCargo", "dbo.Cargo", "Id", cascadeDelete: true);
        }
    }
}
