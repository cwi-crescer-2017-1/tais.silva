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

create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Operações', 'RECIFE');
insert into Departamento values (1, 'Presidência', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);

--- 1
Select   IDEmpregado, NomeEmpregado
From     Empregado 
Order by DataAdmissao

select * from Empregado

--- 2
Select   *
From     Empregado
Where    Comissao = 0 or Comissao is NULL 
Order by Salario

