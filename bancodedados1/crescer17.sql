-- FAZER DOWNLOAD DE BACKUP DE BNCO DE DADOS CRESCER17 DOS INSTRUTORES E NÃO PRECISA CRIAR E INSERIR DADOS ABAIXO

create table Projeto  (
	Projeto             varchar(100),
	Responsavel         varchar(100),
	DataInicio          date,
	DataFimPrevisto     date,
	DataFimReal         date,
	ValorPrevisto       decimal(18,2),
	ValorRealizado      decimal(18,2),
	ValorFaturado       decimal(18,2),
	Empregado           varchar(100),
	ParticipacaoPerc    decimal(3,2)
);

insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Dardano', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Laomedonte', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Príamo', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Páris', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Fred Haise', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Swigert', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Young', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Charles Duke Jr', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Laika', 1.00 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Yuri Gagarin', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Kerim Kerimov', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Valentina Tereshkova', 0.85 );

-- Exercício 1: primeiro nome.
-- Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT TOP(1) LEFT(Projeto.Empregado, REPLACE(CHARINDEX(' ', Projeto.Empregado), 0, LEN(Projeto.Empregado))) as PrimeiroNome,
	          COUNT(1)as TotalOcorrencias
FROM          Projeto
GROUP BY      LEFT(Projeto.Empregado, REPLACE(CHARINDEX(' ', Projeto.Empregado), 0, LEN(Projeto.Empregado)))
ORDER BY      TotalOcorrencias DESC; 

-- Exercício 2: total do Mês.
-- Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.
SELECT COUNT(*) as Quantidade,
	   SUM(ValorPedido) as ValorPedido
FROM   Pedido
WHERE  DATEPART(MONTH, DataPedido) = 4 AND DATEPART(YEAR, DataPedido) = 2017;

-- Exercício 3: Estados x Clientes.
-- Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), 
-- liste também qual o Estado possuí o menor número de clientes.
SELECT UF, TotalClientes
FROM (SELECT TOP(1)
	   ci.UF as UF, COUNT(ci.UF) as TotalClientes
       FROM   Cliente cl
	   INNER JOIN Cidade ci on cl.IDCidade = ci.IDCidade
	   GROUP BY ci.UF
       ORDER BY COUNT(ci.UF)) AS a
UNION ALL
SELECT UF, TotalClientes
FROM (SELECT TOP(1)
	   ci.UF as UF, COUNT(ci.UF) as TotalClientes
       FROM   Cliente cl
	   INNER JOIN Cidade ci on cl.IDCidade = ci.IDCidade
	   GROUP BY ci.UF
       ORDER BY COUNT(ci.UF) DESC) AS b

-- Exercício 4: novo Produto.
-- Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
BEGIN TRANSACTION
ROLLBACK
INSERT into Produto
	(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES
	('Galocha Maragato', getdate(), 35.67, 77.95, 'A')
COMMIT 
go	

-- Exercício 5: Produtos não comprados
-- Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
-- pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
-- Obs.: o produto criado anteriormente deverá ser listado (apenas este)
SELECT *
FROM Produto
WHERE EXISTS 
	(SELECT IDProduto FROM Pedido HAVING Produto.IDProduto)

SELECT *
FROM Produto 
INNER JOIN PedidoItem ON Produto.IDProduto = PedidoItem.IDProduto
Where Produto.IDProduto != PedidoItem.IDProduto

select * from PedidoItem

-- Exercício 6
-- Principais Produtos
-- Liste os 30 produtos que mais geraram lucro em 2016.
SELECT TOP(30)*	   
FROM   Produto
	SELECT(SELECT IDProduto FROM PedidoItem GROUP BY IDProduto ORDER BY COUNT(1))
WHERE  (PrecoVenda - PrecoCusto) * 
ORDER BY 
