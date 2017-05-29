chatzap.controller('LoginController', function($scope, $localStorage, $location, UsuarioService) {
	$scope.controller = 'LoginController';	
	$localStorage.usuario = $localStorage.usuario || null;
	verificaUsuarioLogado();

	function verificaUsuarioLogado() {
	        if ($localStorage.usuario != null) {
	            $location.url('/chat');
	        }
	};	

	$scope.incluirUsuario = function(usuario){
		UsuarioService.adicionar(usuario).then(function(response){
			$localStorage.usuario = response.data;
			window.location.href = "#!/chat";
		})
	};	
});