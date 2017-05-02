-- ABRIR exerciciosLista3 PARA INICIAR TABELA 

-- Exerc�cio 1: m�ltiplos acessos
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

-- Exerc�cio 2: maior Sal�rio
-- Liste o deparamento (id e nome) com o empregado de maior sal�rio.
Select TOP(1)
	   d.IDDepartamento   as IDDepartamento,
	   d.NomeDepartamento as Departamento
From Empregado e
Inner Join Departamento d
				on e.IDDepartamento = d.IDDepartamento
Order by e.salario DESC;

-- Exerc�cio 3: reajuste salarial
-- Aplique uma altera��o salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, este reajuste deve ser de 17,3%. Por seguran�a fa�a uma c�pia da tabela Empregado antes de iniciar esta tarefa.



Exerc�cio 4

Cidades duplicadas

Liste todas as cidades duplicadas (nome e UF iguais).

Exerc�cio 5

Definindo Cidades

Fa�a uma altera�ao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas aten��o! apenas a cidade com maior ID deve ser alterada.

Explica��o adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos � a cria��o de VIEWS. Neste recurso o comando SQL � salvo no dicion�rio de dados do SGBD e pode ser reutilizado novamente.

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