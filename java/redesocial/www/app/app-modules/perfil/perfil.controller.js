angular
	.module('app.core')
	.controller('PerfilController', function ($scope, authService, toastr, LoginService) {

		if(!authService.isAutenticado()){
			$location.path('/home');
		}

		logado = null;

		carregarLogado();

		function carregarLogado(){
			logado = authService.getUsuario().username;
		}

		$scope.novoUsuario = carregarUsuario();	

		function carregarUsuario(){
			LoginService
				.carregar(logado)
				.then((r) => { $scope.novoUsuario = r.data; console.log(r.data); $scope.novoUsuario.senha = null}),
				(r)=> {toastr.warning('Erro na atualização.', 'Depois tente novamente!');};
		}
		
		$scope.atualizar = (usuario) => 
		{
			var myDate = new Date(usuario.dataNascimento);
			var dataEditada =   myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" +  myDate.getDate() + " 00:00:00" ;	
			usuario.dataNascimento = dataEditada;

			console.log(usuario);

			LoginService
				.atualizar(usuario)
				.then(
					(r) => {toastr.success('Atualização realizada com sucesso.', 'Você está novo de novo!');},
					(r)=> {toastr.warning('Erro na atualização.', 'Depois tente novamente!');}
				)
		};

		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});