var app = angular.module('app', []);

app.controller('exercicio', function ($scope) {
	// $scope.novoInstrutor = { "nome": "Taís" };

	// $scope.array = $scope.array.filter(objeto => objeto.id !== id);
	$scope.removerAula = function(aula) {
		
		function tirar() {	
			var index = $scope.aulas.indexOf(aula);		
			$scope.aulas.splice(index, 1);
		}

		let possui = $scope.instrutores.some(i => i.aula.some(a => a === aula.id));

		if(possui) {
			window.alert("Não é possível excluir esta aula. Está sendo utilizada.");
		}else {
			tirar();
		}
	}

	$scope.removerInstrutor = function(instrutor) {
		var index = $scope.aulas.indexOf(instrutor);

		function tirar() {			
			$scope.aulas.splice(index, 1);
		}

		if(item.dandoAula === true) {
			window.alert("Não é possível excluir este instrutor. Está dando instrutor.");
		}else {
			tirar();
		}
		
	}
	// editar, está igual ao outro, customizar
	$scope.alterarInstrutor = function (instrutor){
		let promptNome = prompt("Digite o novo nome:");
		console.log(promptNome);
		promptNome === "" || promptNome === null ? console.log("Não incluiu nome na edição.") : aula.nome = promptNome;
	}

	$scope.editarNomeAula = function (aula){
		let promptNome = prompt("Digite o novo nome:");
		console.log(promptNome);
		promptNome === "" || promptNome === null ? console.log("Não incluiu nome na edição.") : aula.nome = promptNome;
	}

	function gerarProximoId(lista){
		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
	}

	$scope.incluirAula = function (novaAula) {
		if ($scope.formAula.$valid) {
			novaAula.id = gerarProximoId($scope.aulas);
			let valido = !$scope.aulas.find(a => novaAula.nome === a.nome);
			 
			if(valido) {
			    $scope.aulas.push(angular.copy(novaAula));
			    $scope.novaAula = {}
			} else {
			    window.alert("Aula já cadastrada.");
			}
		}
	};
	
	$scope.incluirInstrutor = function (novoInstrutor) {
		if ($scope.formInstrutores.$valid) {
			
		let possui = $scope.instrutores.find(a => novoInstrutor.nome === a.nome);
		let emailUtilizado = $scope.instrutores.find(a => novoInstrutor.email === a.email);

			if(possui) {
				 return window.alert("Instrutor já cadastrado.");
			}if(emailUtilizado){
				return window.alert("Email já está sendo utilizado.");
			}else {
				novoInstrutor.id = gerarProximoId($scope.instrutores);
				$scope.instrutores.push(angular.copy(novoInstrutor));
				$scope.novoInstrutor = {};	
			}	
	 	}
	 };

	$scope.instrutores = 
	[{
	    id: 0,                            // Gerado
	    nome: 'Pedro',                     // Obrigatório (length = min 3, max 20)
	    sobrenome: 'Henrique Pires',           // Opcional (length = max 30)
	    idade: 21,                        // Obrigatório (max 90)
	    email: 'pedro.pires@cwi.com.br',        // Obrigatório (type=email)
	    dandoAula: true,                  // true ou false
	    aula: [3],                     // Opcional (array)
	    urlFoto: 'pedro.jpg'  // Opcional (porém tem uma default de livre escolha)
	},
	{
	    id: 1,
	    nome: 'Bernardo',
	    sobrenome: 'Rezende',
	    idade: 30,
	    email: 'bernardo@cwi.com.br',
	    dandoAula: true,
	    aula: [0, 4],
	    urlFoto: 'bernardo.jpg'
    }];

	$scope.aulas = [
	{
		id: 0,
		nome: 'OO',
	},
	{
		id: 1,
		nome: 'HTML e CSS'
	},
	{
		id: 2,
		nome: 'Javascript' 
	},
	{
		id: 3,
		nome: 'AngularJS'
	},
	{
		id: 4,
		nome: 'Banco de Dados I'
	}];
});