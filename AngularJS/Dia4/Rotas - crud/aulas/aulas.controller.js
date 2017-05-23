angular
  	.module('app')
	.controller('AulasController', function ($scope, aulasService) {
		$scope.controller = 'AulasController';

		// $scope.update = update;

	 	$scope.aulas = aulasService.list().then(function (response) {
	          $scope.aulas = response.data;
	    });

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

				$scope.aulasService.update(aula, inputValue).then(function (response){
					aula.nome = response.data;
				})
			});
		}
		// $scope.array = $scope.array.filter(objeto => objeto.id !== id);
		// $scope.removerAula = function(aula) {
			
		// 	function tirar() {	
		// 		var index = $scope.aulas.indexOf(aula);		
		// 		$scope.aulas.splice(index, 1);
		// 	}

			

		// 	if(possui) {
		// 		swal("Não é possível excluir esta aula. Está sendo utilizada.");
		// 	}else {
		// 		tirar();
		// 		return $scope.sucesso();
		// 	}
		// }

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
