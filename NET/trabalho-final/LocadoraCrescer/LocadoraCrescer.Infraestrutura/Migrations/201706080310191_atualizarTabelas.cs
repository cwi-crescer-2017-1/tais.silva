namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class atualizarTabelas : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Produto", "Valor", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Locacao", "ValorFinal", c => c.Decimal(precision: 18, scale: 2));
            DropColumn("dbo.Produto", "Decimal");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Produto", "Decimal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Locacao", "ValorFinal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Produto", "Valor");
        }
    }
}
