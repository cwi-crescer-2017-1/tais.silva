namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarColunaDataRevisao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            DropColumn("dbo.Livros", "DataRevisão");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Livros", "DataRevisão", c => c.DateTime(nullable: false));
            DropColumn("dbo.Livros", "DataRevisao");
        }
    }
}
