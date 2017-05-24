angular
  	.module('app')
	.controller('AulasController', function ($scope, aulasService) {
		$scope.controller = 'AulasController';

		$scope.carregarAulas = carregarAulas;

		$scope.aulas = aulasService.listar().then(function (response) {
			$scope.aulas = response.data;
		});

		$scope.sucesso = function() {
			return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
		}

		function gerarProximoId(lista){
			return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
		}

		function carregarAulas() {
			aulasService
				.listar()
				.then(function (response) {
					$scope.aulas = response.data;
			    })
		};

		// Acrescentar nova aula.
		$scope.incluirAula = function (novaAula) {
			if ($scope.formAula.$valid) {
				novaAula.id = gerarProximoId($scope.aulas);
						    			    
			    aulasService
			    	.incluir(novaAula)
			    	.then(function () {
				    	carregarAulas();
				    	$scope.novaAula = {}
				    	return $scope.sucesso();
			    	});	
			}
		};		

		// Editar nome de aula.
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
					return false;
				}				

				var aulaModificada = angular.copy(aula);
				aulaModificada.nome = inputValue;

				aulasService
					.alterar(aulaModificada)
					.then(function (response){
						carregarAulas();
						return swal("Pronto!", "Você escreveu: " + inputValue, "success");
					})
			});
		};

		// Remover aula.
		//$scope.array = $scope.array.filter(objeto => objeto.id !== id);
		$scope.removerAula = function(aula) {
			
			aulasService
				.excluir(aula)
				.then(function () {
					carregarAulas();
					return $scope.sucesso();
				})				
			
		}

		swal.setDefaults({
		  confirmButtonColor: '#3399FF'
		});
});
