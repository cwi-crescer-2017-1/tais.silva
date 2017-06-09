angular
	.module('app')
	.controller('LoginController', function ($rootScope, $scope, authService, $location) {
		$scope.controller = 'LoginController';
		$rootScope.logado = authService.isAutenticado();

	  $scope.login = function (usuario) {

	    authService.login(usuario)
	      .then(
	        function (response) {
	          console.log(response);
	          alert('Login com sucesso!');
	          $rootScope.logado = true;
	        },
	        function (response) {
	          console.log(response);
	          alert('Erro no Login!');
	        });
	  };

	  $scope.logout = function (usuario) {
	    authService.logout(usuario);
	    $rootScope.logado = false;
	};
	});