editora.controller('HomeController', function($scope, $localStorage, $location, UsuarioService, LivrosService, $interval) {
	$scope.controller = 'HomeController';	
	$scope.Livros = [];
	$scope.Lancamentos = [];
	carregarLivros();
	carregarLancamentos();

	function carregarLancamentos(){
		LivrosService.carregarLancamentos().then(function(response){
			consolo.log(response.data);
			$scope.Lancamentos = response.data.dados;
		})
	}

	function carregarLivros(){
		LivrosService.carregarLivros().then(function(response){
			$scope.Livros = response.data.dados;
		})
	}	
});