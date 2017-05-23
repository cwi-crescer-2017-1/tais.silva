let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'aulasController',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores', {
      controller: 'instrutoresController',
      templateUrl: 'instrutores.html'
    })
    .otherwise({redirectTo: '/aulas'});
});

app.controller('principalController', function ($scope, $routeParams, aulaService) {
	$scope.controller = 'principalController';	
	$scope.sucesso = function() {
		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
	}

	function gerarProximoId(lista){
		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
	}	

	$scope.aulas = aulaService.list().then(function (response) {
          $scope.aulas = response.data;
    });
});

app.controller('aulasController', function ($scope, aulaService) {
	$scope.controller = 'aulasController';

	// // $scope.aulas = 	function list() {
 // //    	aulaService.list().then(function (response) {
 // //      	$scope.aulas = response.data;
 // //    });
 // //        instrutorService.list().then(function (response) {
 // //      	$scope.instrutores = response.data;
 // //    })};
 // 	instrutorService.list().then(function (response) {
 // //      	$scope.instrutores = response.data;

 // 	$scope.aulas = aulaService.list().then(function (response) {
 //          $scope.aulas = response.data;
 //    });

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

// Inicia todas as divs Accordion fechadas
$('[id^=collapse]').collapse('hide');


swal.setDefaults({
    confirmButtonColor: '#3399FF'
});