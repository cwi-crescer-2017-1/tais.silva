angular
	.module('app')
	.controller('AdminstrativoController', function ($scope, authService) {

	  $scope.auth = authService;

	  $scope.mensagem = {
	    colaborador: 'Mensagem incrível para o usuário AUTENTICADO',
	    administrador: 'Mensagem incrível para o usuário ADMINISTRADOR',
	  };

	});