angular
    .module('app')
    .controller('AmigosController', function($scope, authService, toastr, LoginService, PrivadoService, $routeParams, PostsService){
    
        if(!authService.isAutenticado()){
			$location.path('/home');
		}
        
        $scope.amigos = {};
        carregarAmigos();        

        function carregarAmigos(){
             PrivadoService
            .carregarAceitas()
            .then((r)=> { $scope.amigos = r.data; console.log(r.data)})
        }
        
        //Logout
		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
    })