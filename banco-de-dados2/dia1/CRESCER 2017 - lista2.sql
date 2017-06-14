-- Exercício 1
-- Atualmente a tabela de Cidade tem registros duplicados (nome e UF).
-- Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
-- Após isso liste todos os clientes que estão relacionados com estas cidades
DECLARE
   CURSOR C_ListaDupli IS
     Select Nome,
            Uf
     From   Cidade
     Group  By Nome, Uf
     Having count(1) > 1;
   --
   CURSOR C_ListaCli IS
     Select cl.IDCliente,
            cl.Nome as NomeCliente,
            cd.Nome,
            cd.Uf
     From   Cidade cd
     Inner Join Cliente cl on cl.IDCidade = cd.IDCidade
     Order By cl.Nome;
BEGIN
  FOR cli IN C_ListaCli LOOP
    FOR dup IN C_ListaDupli LOOP
      if(cli.Nome = dup.Nome and cli.Uf = dup.Uf) then 
        DBMS_OUTPUT.PUT_LINE('Nome: ' || cli.NomeCliente);
      END IF;
    END LOOP;
   END LOOP;
END;

-- Exercício 2
-- Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
--Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).
DECLARE
 CURSOR C_ListaPed (pIDPedido in number) IS
     Select SUM(Quantidade * PrecoUnitario) as ValorTotal
     From   PedidoItem
     Where  IDPedido = pIDPedido;
  vPedido  Pedido.IDPedido%TYPE;
BEGIN
   vPedido := 5;
   for reg in C_ListaPed(vPedido)loop
      update PEDIDO
      set VALORPEDIDO = reg.ValorTotal
      where IDPedido = vPedido;
    end loop;   
END;

-- Exercício 3
-- Crie uma rotina que atualize todos os clientes que não realizaram nenhum 
-- pedido nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior). 
-- Definir o atributo Situacao para I.
DECLARE
  CURSOR C_ListaCli IS
    SELECT c.IDCliente, c.Nome, c.Situacao 
    FROM Cliente c
    INNER JOIN Pedido p ON c.IDCliente = p.IDCliente
    WHERE IDPedido NOT IN  (SELECT IDPedido 
                             FROM PedidoItem item
                             WHERE p.DataPedido >= ADD_MONTHS(TRUNC(SYSDATE),-6));
BEGIN
   for reg in C_ListaCli loop
      update CLIENTE
      set SITUACAO = 'I'
      where IDCliente = reg.IDCliente;
    end loop;   
END;

-- Exercício 4
-- Faça uma rotina que receba dois parâmetros: IDProduto & Mês e Ano
-- E então faça uma rotina que verifique no ANO/MÊS para o produto informado qual
-- a lista de materiais (incluindo a quantidade) é necessário para atender todos 
-- os Pedidos desde período. Deve imprimir o nome do material e quantidade total.
DECLARE
 CURSOR C_ListaPro (pIDProduto in number, vData in date) IS
     Select SUM(pi.Quantidade) as QuantidadePedido, pi.IdProduto as IdProduto
     From   PedidoItem pi
     INNER JOIN Pedido ped ON pi.IDPedido = ped.IDPedido
     Where  EXTRACT(Month FROM ped.DataPedido) = EXTRACT(Month FROM vData) AND EXTRACT(Year FROM ped.DataPedido) = EXTRACT(Year FROM vData) AND ped.IdProduto = pIdProduto;
 CURSOR C_ListaMate (pIDProduto in number) IS
     Select SUM(pm.Quantidade) as QuantidadeTotal, pr.Nome as NomeMaterial
     From   ProdutoMaterial  pm
     INNER JOIN Produto pr ON pm.IDProduto = pr.IDProduto
     Where  pm.IdProduto = pIDProduto;
  vProduto  Produto.IDProduto%TYPE;
  vData     Pedido.DataPedido%TYPE;
BEGIN
   vProduto := 5;
   vData := ;
   for mate in C_ListaMate(vProduto) loop
      for pro in C_ListaPro(vProduto, vData) loop
        DBMS_OUTPUT.PUT_LINE('Material: ' || mate.NomeMaterial, 'Quantidade': || (pro.QuantidadePedido * mate.QuantidadeTotal));
      end loop;
    end loop;   
END;
