namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alterarLocacao : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Usuario");
            DropIndex("dbo.Locacao", new[] { "IdFuncionario" });
            DropColumn("dbo.Locacao", "IdFuncionario");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Locacao", "IdFuncionario", c => c.Int(nullable: false));
            CreateIndex("dbo.Locacao", "IdFuncionario");
            AddForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Usuario", "Id", cascadeDelete: true);
        }
    }
}
