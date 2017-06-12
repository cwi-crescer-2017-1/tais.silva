CREATE TABLE Pessoa (
  IDPessoa   integer not null,
  Nome       varchar2(30) not null,
     constraint PK_Pessoa primary key (IDPessoa)
);

Create sequence SQPessoa;

Insert Into Pessoa (IDPessoa, Nome)
 Values (SQPessoa.nextval, 'Andre');
 
 COMMIT;

-- Produtos inativos
select IDPRODUTO, NOME
from PRODUTO 
where IDPRODUTO NOT IN
(select IDPRODUTO 
from PEDIDOITEM pi
Inner Join PEDIDO pd
          on pi.IDPEDIDO = pd.IDPEDIDO 
          where DATAPEDIDO >= ADD_MONTHS(SYSDATE,-4))

-- Alterando status
-- Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.
update PRODUTO 
set SITUACAO = 'I'
where IDPRODUTO NOT IN
(select IDPRODUTO 
from PEDIDOITEM pi
Inner Join PEDIDO pd
          on pi.IDPEDIDO = pd.IDPEDIDO 
          where DATAPEDIDO >= ADD_MONTHS(SYSDATE,-4))
          
-- Parametro
-- Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade 
-- de itens na tabela PedidoItem com este IDProduto foram vendidos
-- no último ano (desde janeiro/2017).
DEFINE IdParametro = 5          
select pr.IDPRODUTO, COUNT(pi.QUANTIDADE) 
from PRODUTO pr
join PEDIDOITEM pi
on pr.IDPRODUTO = pi.IDPRODUTO
and pi.IDPRODUTO = :IdParametro
join PEDIDO pd 
on pi.IDPEDIDO = pd.IDPEDIDO
where pd.DATAPEDIDO >= TO_DATE(201701, 'YYYYMM')
group by pr.IDPRODUTO 




      