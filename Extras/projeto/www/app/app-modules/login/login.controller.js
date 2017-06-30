angular
	.module('app')
	.controller('LoginController', function ($rootScope, $scope, authService, $location, $localStorage, toastr) {
		$scope.controller = 'LoginController';
		$rootScope.logado = authService.isAutenticado();

	  $scope.login = function (usuario) {

	    authService.login(usuario)
	      .then(
	        function (response) {
	          toastr.success('Login realizado com sucesso.', 'Você está dentro!');
	          var usuarioLogado = response.data.dados;

				if(!angular.isArray(usuarioLogado.Permissoes)) {
				    usuarioLogado.Permissoes = [usuarioLogado.Permissoes];
				}

				$localStorage.usuarioLogado = usuarioLogado;
	          	$rootScope.logado = true;
	        },
	        function (response) {
	          toastr.warning('Erro no login.', 'Tente novamente mais tarde!');
	        });
	  };

	  $scope.logout = function (usuario) {
	    authService.logout(usuario);
	    $rootScope.logado = false;
	    toastr.success('Logout realizado com sucesso.', 'Você está fora!');
	};
	});