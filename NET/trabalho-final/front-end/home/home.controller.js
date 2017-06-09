
angular
	.module('app')
	.controller('HomeController', function($scope, $uibModal, $localStorage, $location, administrativoService) {
		$scope.controller = 'HomeController';		
		$scope.produtos = [];
		$scope.pacotes = [];
		$scope.extras = [];
	  	carregarTabelaProduto();
	  	carregarTabelaPacote();
	  	carregarTabelaExtra();


		function carregarTabelaProduto(){
			administrativoService
				.carregarProduto()
				.then(function(response){
					console.log("carregarProduto", response.data);
					$scope.produtos = response.data.dados;
				})
		}
		function carregarTabelaPacote(){
			administrativoService
				.carregarPacote()
				.then(function(response){
					console.log("carregarPacote", response.data);
					$scope.pacotes = response.data.dados;
				})
		}
		function carregarTabelaExtra(){
			administrativoService
				.carregarExtra()
				.then(function(response){
					console.log("carregarExtra", response.data);
					$scope.extras = response.data.dados;
				})
		}

	});