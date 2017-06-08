
angular
	.module('app')
	.controller('HomeController', function($scope, $uibModal, $localStorage, $location, administrativoService) {
		$scope.controller = 'HomeController';		
		$scope.produtos = [];
		$scope.pacotes = [];
		$scope.extras = [];
	  	carregarTabelas();

		function carregarTabelas(){
			administrativoService
				.carregarProduto()
				.then(function(response){
					console.log("carregarProduto", response.data);
					$scope.produtos = response.data.dados;
				})
				.carregarPacote()
				.then(function(response){
					console.log("carregarPacote", response.data);
					$scope.pacotes = response.data.dados;
				})
				.carregarExtra()
				.then(function(response){
					console.log("carregarExtra", response.data);
					$scope.extras = response.data.dados;
				})
		}

		// $scope.carregarInformacoes = function (isbn){
		// 	livrosService.carregarIsbn(isbn).then(function(response){
		// 		$scope.livroComp = response.data.dados;
		// 		$uibModal.open({
		// 			backdrop: true,
		// 			templateUrl: 'myModalContent.html',
		// 			controller: function($scope, $uibModalInstance) {
		// 				$scope.livroComp = response.data.dados;
		// 				$scope.cancel = function(){
		// 					$uibModalInstance.dismiss();
		// 				}
		// 			}
		// 		})
		// 	});
		// };
	});