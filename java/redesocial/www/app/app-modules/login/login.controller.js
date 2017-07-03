angular
	.module('app')
	.controller('LoginController', function ($scope, authService, $location, $localStorage, toastr, LoginService) {

		$usuarioLogado = null;

		$scope.cadastrar = (usuario) => 
		{
			usuario.dataNascimento = formatarData(usuario.dataNascimento);
			console.log(usuario);

			LoginService
				.salvar(usuario)
				.then(
					(r) => {toastr.success('Cadastro realizado com sucesso.', 'Você está dentro!'); $scope.login(usuario);},
					(r)=> {toastr.warning('Erro no cadastro.', 'Depois tente novamente!')}
				)
		};

		function formatarData(data){
			var myDate = new Date(data);
			return myDate.getFullYear() + "-" + ('0' + (myDate.getMonth() + 1)).slice(-2) + "-" +  ('0' + myDate.getDate()).slice(-2) + " 00:00:00";	
		}
        
		if(authService.isAutenticado()){
			$location.path('/privado');
		}

	  $scope.login = function (usuario) {
	    authService.login(usuario)
	      .then(
	        function (response) {
	          // $log.debug(response);
	          toastr.success('Login realizado com sucesso.', 'Você está dentro!');

	        },
	        function (response) {
	          // $log.debug(response);
	          toastr.warning('Erro no login.', 'Depois tente novamente!');
	        });
	  };

		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});