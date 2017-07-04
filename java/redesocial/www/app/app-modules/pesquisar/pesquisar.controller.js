angular
	.module('app.core')
	.controller('PesquisarController', function ($scope, authService, toastr, LoginService, PesquisarService, $location) {

		if(!authService.isAutenticado()){
			$location.path('/home');
		}

		logado = null;

		$scope.usuarios = null;

		carregarLogado();		

		function carregarLogado(){
			logado = authService.getUsuario().username;
		}		

		carregarUsuarios();

		function carregarUsuarios(){
			PesquisarService.carregar().then((r) => {$scope.usuarios = r.data; console.log(r.data)});
		}	

		$scope.verPerfil = (id) => {$location.url(`/detalhado/${id}`)};		
				
		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});