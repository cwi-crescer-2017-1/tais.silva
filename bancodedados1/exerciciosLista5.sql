-- ABRIR exerciciosLista3 PARA INICIAR TABELA 

-- Exercício 1: múltiplos acessos
-- Liste o nome do empregado, o nome do gerente e o departamento de cada um.
Select e.NomeEmpregado    as Nome,       
	   d.NomeDepartamento as DepartamentoEmpregado,
	   g.NomeEmpregado    as NomeGerente,
	   d.NomeDepartamento as DepartamentoGerente
From   Empregado e
Inner Join Empregado g
				on e.IDGerente = g.IDEmpregado
Inner Join Departamento d
				on e.IDDepartamento = d.IDDepartamento

-- Exercício 2: maior Salário
-- Liste o deparamento (id e nome) com o empregado de maior salário.
Select TOP(1)
	   d.IDDepartamento   as IDDepartamento,
	   d.NomeDepartamento as Departamento
From Empregado e
Inner Join Departamento d
				on e.IDDepartamento = d.IDDepartamento
Order by e.salario DESC;

-- Exercício 3: reajuste salarial
-- Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO,
-- este reajuste deve ser de 17,3%.
-- Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
BEGIN TRANSACTION

Select *  
	   Format(((Salario * 0.173) + Salario), '#,00') as Salario
From   Empregado e
Inner Join Departamento d
				on e.IDDepartamento = d.IDDepartamento
				Where d.Localizacao = 'SAO PAULO'

				select* from departamento

-- Exercício 4: cidades duplicadas
-- Liste todas as cidades duplicadas (nome e UF iguais).

Select Nome, 
	   UF
From   Cidade
Group By Nome



-- Exercício 5: definindo Cidades
-- Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas atenção! apenas a cidade com maior ID deve ser alterada.
Explicação adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos é a criação de VIEWS. Neste recurso o comando SQL é salvo no dicionário de dados do SGBD e pode ser reutilizado novamente.

Um exemplo disso seria uma consulta que retorna apenas as cidades do RS.

Create view vwCidades_Gauchas as
   Select IDCidade,
          Nome
   From   Cidade
   Where  UF = 'RS';
Para utilizar esta consulta ela deve ser referenciada no FROM como se fosse uma fonte de dados qualquer:

Select IDCidade, 
       Nome 
  From vwCidades_Gauchas;