
angular
	.module('app')
	.controller('HomeController', function($scope, $uibModal, $localStorage, $location, livrosService) {
		$scope.controller = 'HomeController';		
		$scope.Lancamentos = [];
		$scope.Livros = [];
		$scope.parametros = {
	      quantidadeTrazer: 6,
	      quantidadePular: 0,
	    };   
	    $scope.quantidadeLivros = 0; 
	    $scope.paginaAtual = 0;
	  	carregarLivros($scope.parametros);
		carregarLancamentos();
		$scope.trocarPaginas = trocarPaginas;

		$scope.carregarInformacoes = function (isbn){
			livrosService.carregarIsbn(isbn).then(function(response){
				$scope.livroComp = response.data.dados;
				$uibModal.open({
					backdrop: true,
					templateUrl: 'myModalContent.html',
					controller: function($scope, $uibModalInstance) {
						$scope.livroComp = response.data.dados;
						$scope.cancel = function(){
							$uibModalInstance.dismiss();
						}
					}
				})
			});
		};

		function carregarLancamentos(){
			livrosService
				.carregarLancamentos()
				.then(function(response){
					console.log("lancamentos", response.data);
					$scope.Lancamentos = response.data.dados;
				})
		}

		function trocarPaginas(){
			$scope.parametros.quantidadePular = ($scope.paginaAtual - 1) * $scope.parametros.quantidadeTrazer;
			carregarLivros($scope.parametros);
		}

		function carregarLivros(parametros){
			livrosService
				.carregarLivros(parametros)
				.then(function(response){
					console.log("Livros", response.data.dados);
					$scope.quantidadeLivros = response.data.quantidade;			
					$scope.Livros = response.data.dados;
				})
		}	
	});