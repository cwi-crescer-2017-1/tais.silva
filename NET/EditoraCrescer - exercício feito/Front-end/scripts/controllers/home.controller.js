editora.controller('HomeController', function($scope, $localStorage, $location, LivrosService) {
	$scope.controller = 'HomeController';	
	$scope.Livros = [];
	$scope.Lancamentos = [];
	$scope.parametros = {
      quantidadeTrazer: 5,
      quantidadePular: 0,
    };
	carregarLivros();
	carregarLancamentos();

	function carregarLancamentos(){
		LivrosService.carregarLancamentos().then(function(response){
			console.log(response.data);
			$scope.Lancamentos = response.data.dados;
		})
	}

	function carregarLivros(parametros){
		LivrosService.carregarLivros().then(function(response){
			console.log("Livros", response.data.dados);
			$scope.Livros = response.data.dados;
		})
	}	
});