editora.controller('HomeController', function($scope, LivrosService) {
	$scope.controller = 'HomeController';	
	$scope.Livros = [];
	$scope.Lancamentos = [];
	carregarLivros();
	carregarLancamentos();

	function carregarLancamentos(){
		LivrosService.carregarLancamentos().then(function(response){
			console.log(response.data);
			$scope.Lancamentos = response.data.dados;
		})
	}

	function carregarLivros(){
		LivrosService.carregarLivros().then(function(response){
			$scope.Livros = response.data.dados;
		})
	}	
});