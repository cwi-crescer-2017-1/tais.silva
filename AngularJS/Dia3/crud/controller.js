var app = angular.module('app', []);

app.controller('exercicio', function ($scope) {

	$scope.sucesso = function() {
		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
	}

	$scope.editarNomeAula = function (aula){
		
		swal({
		  title: "Editar nome",
		  text: "Digite o novo nome:",
		  type: "input",
		  showCancelButton: true,
		  closeOnConfirm: false,
		  animation: "slide-from-top",
		  inputPlaceholder: "Novo nome"
		},		
		function(inputValue){
		  if (inputValue === false) return false;
		  
		  if (inputValue === "") {
		    swal.showInputError("Você precisa escrever o novo nome!");
		    return false
		  }
		  
		  swal("Pronto!", "Você escreveu: " + inputValue, "success");
		  aula.nome = inputValue;
		});
	}

	// $scope.array = $scope.array.filter(objeto => objeto.id !== id);
	$scope.removerAula = function(aula) {
		
		function tirar() {	
			var index = $scope.aulas.indexOf(aula);		
			$scope.aulas.splice(index, 1);
		}

		let possui = $scope.instrutores.some(i => i.aula.some(a => a === aula.id));

		if(possui) {
			swal("Não é possível excluir esta aula. Está sendo utilizada.");
		}else {
			tirar();
			return $scope.sucesso();
		}
	}

	$scope.removerInstrutor = function(instrutor) {
		
		var index = $scope.instrutores.indexOf(instrutor);

		function tirar() {			
			$scope.instrutores.splice(index, 1);
		}

		if(instrutor.dandoAula === true) {
			swal("Não é possível excluir este instrutor. Está dando instrutor.");
		}else {
			tirar();
			return $scope.sucesso();
		}
		
	}

	$scope.editarInstrutor = function (instrutor){
		
		if ($scope.formInstrutores.$valid) {
			console.log("dentro");
			let validaNome = function(instrutor) {
				let valido = true;				
		 		for (i = 0; i < $scope.instrutores.length; i++ ){
		 			if (instrutor.id == $scope.instrutores[i].id) {
		 				continue;
		 			}if (instrutor.nome == $scope.instrutores[i].nome) {
		 				swal("Instrutor já cadastrado.");
		 				valido = false;
		 				break;
		 			}if(instrutor.email == $scope.instrutores[i].email) {
		 				swal("Email já está sendo utilizado.");
		 				valido = false;
		 				break;
		 			}
		 		}
		 		return valido;
		 	}

		 	if(validaNome(instrutor)){
		 		console.log("entrou no valido");
		 		var index = $scope.instrutores.indexOf(instrutor);
				$scope.instrutores[index] = instrutor;

				return $scope.sucesso();				
			}
			
	 	}
	}

	function gerarProximoId(lista){
		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
	}

	$scope.incluirAula = function (novaAula) {
		if ($scope.formAula.$valid) {
			novaAula.id = gerarProximoId($scope.aulas);
			let valido = !$scope.aulas.some(a => novaAula.nome === a.nome);
			 
			if(valido) {
			    $scope.aulas.push(angular.copy(novaAula));
			    $scope.novaAula = {}
			    return $scope.sucesso();
			} else {
			    swal("Aula já cadastrada.");
			}
		}
	};
	
	$scope.incluirInstrutor = function (novoInstrutor) {
		if ($scope.formInstrutores.$valid) {

			let possui = $scope.instrutores.find(a => novoInstrutor.nome === a.nome);
			let emailUtilizado = $scope.instrutores.find(a => novoInstrutor.email === a.email);
			if (!novoInstrutor.urlFoto) {
			    novoInstrutor.urlFoto = "foto-padrao.jpg";
			}
			if(!novoInstrutor.dandoAula) {
				novoInstrutor.dandoAula = false;
			}
			if(possui) {
				 return swal("Instrutor já cadastrado.");
			}if(emailUtilizado){
				return swal("Email já está sendo utilizado.");
			}else {
				novoInstrutor.id = gerarProximoId($scope.instrutores);
				$scope.instrutores.push(angular.copy(novoInstrutor));
				$scope.novoInstrutor = {};	
				return $scope.sucesso();
			}	
	 	}
	 };

	$scope.instrutores = 
	[{
	    id: 0,                            	// Gerado
	    nome: 'Pedro',                     	// Obrigatório (length = min 3, max 20)
	    sobrenome: 'Henrique Pires',       	// Opcional (length = max 30)
	    idade: 21,                       	// Obrigatório (max 90)
	    email: 'pedro.pires@cwi.com.br',   	// Obrigatório (type=email)
	    dandoAula: false,                  	// true ou false
	    aula: [3],                     		// Opcional (array)
	    urlFoto: 'pedro.jpg'  				// Opcional (porém tem uma default de livre escolha)
	},
	{
	    id: 1,
	    nome: 'Bernardo',
	    sobrenome: 'Rezende',
	    idade: 30,
	    email: 'bernardo@cwi.com.br',
	    dandoAula: false,
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

// Inicia todas as divs Accordion fechadas
$('[id^=collapse]').collapse('hide');

