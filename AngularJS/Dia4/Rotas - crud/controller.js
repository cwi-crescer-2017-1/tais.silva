let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/pagina01', {
      controller: 'aulasController',
      templateUrl: 'aulas.html'
    })
    .when('/pagina02', {
      controller: 'instrutoresController',
      templateUrl: 'instrutores.html'
    })
    .otherwise({redirectTo: '/pagina01'});
});

app.controller('principalController', function ($scope) {
	$scope.controller = 'principalController';	
	$scope.sucesso = function() {
		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
	}

	function gerarProximoId(lista){
		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
	}	

	$scope.instrutores = 
	[{
	    id: 0,                            	// Gerado
	    nome: 'Pedro',                     	// Obrigatório (length = min 3, max 20)
	    sobrenome: 'Henrique Pires',       	// Opcional (length = max 30)
	    idade: 21,                       	// Obrigatório (max 90)
	    email: 'pedro.pires@cwi.com.br',   	// Obrigatório (type=email)
	    dandoAula: false,                  	// true ou false
	    aula: [1],                     		// Opcional (array)
	    urlFoto: 'pedro.jpg'  				// Opcional (porém tem uma default de livre escolha)
	},
	{
	    id: 1,
	    nome: 'Bernardo',
	    sobrenome: 'Rezende',
	    idade: 30,
	    email: 'bernardo@cwi.com.br',
	    dandoAula: false,
	    aula: [0, 2],
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

	// Inicia todas as divs Accordion fechadas
	$('[id^=collapse]').collapse('hide');
});

app.controller('aulasController', function ($scope) {
	$scope.controller = 'aulasController';
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
});

app.controller('instrutoresController', function ($scope) {
	$scope.controller = 'instrutoresController';

	// Inicia todas as divs Accordion fechadas
	$('[id^=collapse]').collapse('hide');

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

     function validaNome(instrutor) {
        var aux = procuraPorId(instrutor.id);
        return aux.nome === instrutor.nome ? false : $scope.instrutores.filter(i => i.id !== instrutor.id).some(i => i.nome === instrutor.nome);  
    }

    function validaEmail(instrutor){
        var aux = procuraPorId(instrutor.id);
        return aux.email === instrutor.email ? false : $scope.instrutores.filter(i => i.id !== instrutor.id).some(i => i.email === instrutor.email);  
    }	 		
                 
	function procuraPorId(id){
		return $scope.instrutores.find(i => i.id === id);
	}

	$scope.carregaInformacoes = function (id){
		$scope.edit = angular.copy(procuraPorId(id));
	};

	$scope.editarInstrutor = function(instrutor) {
		
		if ($scope.form.$valid) {
            if(validaNome(instrutor)){
                sweetAlert("Oops...", "Esse nome já existe, verifique!", "warning");
            }
            else if(validaEmail(instrutor)){
                sweetAlert("Oops...", "Esse email já existe, verifique!", "warning");
            }
            else {
		 		var aux = procuraPorId(instrutor.id);
                var index = $scope.instrutores.indexOf(aux);
				$scope.instrutores[index] = instrutor;
				return $scope.sucesso();				
			}	
	 	}else {
	 		swal("Preencha todos os campos em vermelho corretamente.");
	 	}
    }     

    $scope.incluirInstrutor = function (novoInstrutor) {
		if ($scope.formInstrutores.$valid) {

			let possui = $scope.instrutores.find(a => novoInstrutor.nome === a.nome);
			let emailUtilizado = $scope.instrutores.find(a => novoInstrutor.email === a.email);
			if (!novoInstrutor.urlFoto) {
			    novoInstrutor.urlFoto = "foto-padrao.jpg";
			}if(!novoInstrutor.dandoAula) {
				novoInstrutor.dandoAula = false;
			}if(possui) {
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

});