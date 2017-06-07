namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class criacaoTabelas : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Endereco = c.String(),
                        Cpf = c.String(),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Extra",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
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
                        Cargo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataPrevista = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(),
                        ValorPrevisto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorFinal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdFuncionario = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Usuario", t => t.IdFuncionario, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdFuncionario)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descirção = c.String(),
                        Duracao = c.Int(nullable: false),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Decimal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoExtra",
                c => new
                    {
                        IdExtra = c.Int(nullable: false),
                        Extra_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdExtra, t.Extra_Id })
                .ForeignKey("dbo.Locacao", t => t.IdExtra, cascadeDelete: true)
                .ForeignKey("dbo.Extra", t => t.Extra_Id, cascadeDelete: true)
                .Index(t => t.IdExtra)
                .Index(t => t.Extra_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Locacao", "IdFuncionario", "dbo.Usuario");
            DropForeignKey("dbo.LocacaoExtra", "Extra_Id", "dbo.Extra");
            DropForeignKey("dbo.LocacaoExtra", "IdExtra", "dbo.Locacao");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.LocacaoExtra", new[] { "Extra_Id" });
            DropIndex("dbo.LocacaoExtra", new[] { "IdExtra" });
            DropIndex("dbo.Locacao", new[] { "IdProduto" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdFuncionario" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.LocacaoExtra");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Locacao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Extra");
            DropTable("dbo.Cliente");
        }
    }
}
