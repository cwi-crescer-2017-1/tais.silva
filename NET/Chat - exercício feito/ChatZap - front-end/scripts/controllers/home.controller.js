chatzap.controller('HomeController', function($scope, $localStorage, $location, UsuarioService, MensagemService, $interval) {
	$scope.controller = 'HomeController';	
	$scope.ultimosCadastrados = [];
	$scope.ultimaAtualizacaoCadastrados = Date.now();
	$scope.usuarios = [];
	ultimosCadastrados();

	function ultimosCadastrados(){
		UsuarioService.carregar().then(function(response){
			$scope.ultimosCadastrados = response.data;
			$scope.ultimaAtualizacaoCadastrados = Date.now();
		});
	}

	$interval(ultimosCadastrados, 60000);
});