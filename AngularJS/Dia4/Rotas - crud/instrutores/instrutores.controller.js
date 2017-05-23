angular
    .module('app')
    .controller('InstrutoresController', function ($scope, instrutoresService, aulasService) {
    	$scope.controller = 'InstrutoresController';
    	
    	$scope.instrutores = instrutoresService.list().then(function(response){
    		$scope.instrutores = response.data;
    	})

    	$scope.aulas = aulasService.list().then(function (response) {
	          $scope.aulas = response.data;
	    });

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

	function gerarProximoId(lista){
		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
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