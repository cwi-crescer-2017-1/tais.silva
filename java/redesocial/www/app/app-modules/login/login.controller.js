angular
	.module('app.core')
	.controller('LoginController', function ($scope, authService, $location, $localStorage, toastr, uibDateParser, LoginService) {

		$scope.cadastrar = (usuario) => 
		{LoginService
			.salvar(usuario)
			.then(
				(r) => {toastr.success('Cadastro realizado com sucesso.', 'Você está dentro!');},
				()=> {toastr.warning('Erro no cadastro.', 'Depois tente novamente!')}
			)};
        
		// if(authService.isAutenticado()){
		// 	$location.path('/privado');
		// }

	  $scope.login = function (usuario) {
	    authService.login(usuario)
	      .then(
	        function (response) {
	          $log.debug(response);
	          toastr.success('Login realizado com sucesso.', 'Você está dentro!');

	        },
	        function (response) {
	          $log.debug(response);
	          toastr.warning('Erro no login.', 'Depois tente novamente!');
	        });
	  };

		$scope.logout = function (usuario) {
				authService.logout(usuario);
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});