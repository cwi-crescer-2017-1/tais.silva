chatzap.controller('LoginController', function($scope, $localStorage, toastr, $location, UsuarioService) {
	$scope.controller = 'LoginController';	
	$localStorage.usuario = $localStorage.usuario || null;
	// $localStorage.usuario = $localStorage.length > 0 ? $localStorage.usuario: null;
	verificaUsuarioLogado();

	function verificaUsuarioLogado() {
	        if ($localStorage.usuario !== null) {
	            $location.url('/chat');
	        }
	};	

	$scope.incluirUsuario = function(usuario){
		UsuarioService.adicionar(usuario).then(function(response){
			$localStorage.usuario = response.data;
			toastr.success('Cadastro realizado com sucesso.', 'Bem vindo!');
			$location.url("/chat");
		})
	};	
});