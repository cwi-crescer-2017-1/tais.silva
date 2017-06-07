angular
	.module('app')
	.controller('LoginController', function ($scope, authService, $location) {
		$scope.controller = 'LoginController';

		if(authService.isAutenticado()){
			$location.path('/adminstrativo');
		}

	  $scope.login = function (usuario) {

	    authService.login(usuario)
	      .then(
	        function (response) {
	          console.log(response);
	          alert('Login com sucesso!');

	        },
	        function (response) {
	          console.log(response);
	          alert('Erro no Login!');
	        });
	  };

	  $scope.logout = function (usuario) {

	    authService.logout(usuario)
	      .then(
	        function (response) {
	          console.log(response);
	          alert('Você saiu!');

	        },
	        function (response) {
	          console.log(response);
	          alert('Erro ao sair, tente mais tarde!');
	        });
	  };
	});