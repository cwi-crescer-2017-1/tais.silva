angular
	.module('app.core')
	.controller('PrivadoController', function ($scope, authService, toastr, LoginService) {

		if(!authService.isAutenticado()){
			$location.path('/home');
		}

		$scope.solicitantes = ()=> {Login}

		$scope.usuario = null;

		logado = null;

		carregarLogado();

		function carregarLogado(){
			logado = authService.getUsuario().username;
		}

		$scope.novoUsuario = carregarUsuario();	

		function carregarUsuario(){
			LoginService
				.carregar(logado)
				.then((r) => { $scope.usuario = r.data; console.log(r.data); $scope.usuario.senha = null}),
				(r)=> {toastr.warning('Erro na atualização.', 'Depois tente novamente!');};
		}

		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});