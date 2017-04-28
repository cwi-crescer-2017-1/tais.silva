-- LISTA DE RESPOSTAS DA LISTA 1 - SQL

/* 1) Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. 
   Considere todos os registros existentes. */
select * 
into   CidadeAux 
from   Cidade;

/* 2) Limpe a tabela CidadeAux (Truncate table CidadeAux). 
      E em seguida insira todas os registros da tabela Cidade onde o estado seja RS.
*/
Truncate table CidadeAux;

Insert into CidadeAux (IDCidade, Nome, UF)
   Select IDCidade, Nome, UF
   From   Cidade
   Where  UF = 'RS';

/*
4) Crie uma tabela para armazenar informações de produtos. Devem ter os seguintes atributos:
Código de identificação;
Nome curto,
Nome descritivo,
Data da criação,
Local no estoque,
Quantidade e
Preço.
*/

create table Produto (
  IDProduto    int identity not null,
  Nome         varchar(20)  not null,
  Descricao    varchar(60)  not null,
  LocalEstoque varchar(30)  not null,
  DataCriacao  date         not null,
  Quantidade   decimal(7,3) not null,
  Preco        decimal(9,2) not null,
    constraint PK_Produto primary key (IDProduto)
);

/*
4) Crie dois registros nessa tabela nova (produto).
*/
-- INSERINDO 2 PRODUTOS, CONSIDERANDO QUE UM DELES PODE TER QUANTIDADE NÃO INTEIRA
BEGIN TRANSACTION

insert into Produto 
  (Nome, 
   Descricao, 
   LocalEstoque, 
   DataCriacao, 
   Quantidade, 
   Preco)
  values 
   ('Farinha de mandioca', 
    'Farinha de mandioca 1KG', 
	'Deposito Sul', 
	 getdate(), -- data e hora do servidor de banco de dados
	 1, 
	 3.49);


insert into Produto (Nome, Descricao, LocalEstoque, DataCriacao, Quantidade, Preco)
  values ('Batata rosa', 'Batata inglesa rosa', 'Fruteira', getdate(), 1.5, 2.15);

COMMIT