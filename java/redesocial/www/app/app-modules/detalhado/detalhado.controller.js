angular
	.module('app.core')
	.controller('DetalhadoController', function ($scope, authService, toastr, LoginService, PrivadoService, $routeParams) {

		if(!authService.isAutenticado()){
			$location.path('/home');
		}

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

		// Solicitações de amizade
		$scope.solicitantes = null;
		carregarSolicitantes();
		
		function carregarSolicitantes() {	
			PrivadoService
				.carregarAmizadesPendentes()
				.then((r)=> { 
					$scope.solicitantes = r.data; 
					console.log("solitantes:", r.data);
				})
		}; 

		$scope.aceitar = (idAmizade) => {
		PrivadoService
			.aceitar(idAmizade)
			.then((r) => { toastr.success('Sucesso.', 'Agora vocês são amigos!'); carregarSolicitantes();}),
			(r)=> {toastr.warning('Erro ao adicionar.', 'Depois tente novamente!');};
		}

		$scope.rejeitar = (idAmizade) => {
		PrivadoService
			.rejeitar(idAmizade)
			.then((r) => { toastr.success('Amizade rejeitada.', 'Vocês são serão amigos!'); carregarSolicitantes();}),
			(r)=> {toastr.warning('Erro ao rejeitar.', 'Depois tente novamente!');};
		}
		// Fim solicitações de amizade

		// Solicitações pendentes
		$scope.pendentes = null;
		carregarPendentes();
		
		function carregarPendentes() {	
			PrivadoService
				.carregarPendentes()
				.then((r)=> { 
					$scope.pendentes = r.data; 
					console.log("pendentes:", r.data);
				})
		}; 
		// Fim solicitações pendentes

		//Logout
		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});