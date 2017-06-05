angular
	.module('app')
	.controller('HomeController', function($scope, $localStorage, $location, livrosService) {
		$scope.controller = 'HomeController';	
		$scope.Livros = [];
		$scope.Lancamentos = [];
		$scope.parametros = {
	      quantidadeTrazer: 5,
	      quantidadePular: 0,
	    };   
	    $scope.quantidadeLivros = 0; 
	    $scope.paginaAtual = 0;
	  	carregarLivros($scope.parametros);
		carregarLancamentos();
		$scope.trocarPaginas = trocarPaginas;

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