angular
  .module('app')
  .controller('HomeController', function ($scope, aulasService, instrutoresService) {
  	$scope.controller = 'HomeController';
    $scope.instrutores = [];
    $scope.aulas = [];
    carregar();

    function carregar() {
      aulasService.listar().then(function (response) {
        $scope.aulas = response.data;
      });
      instrutoresService.listar().then(function (response) {
        $scope.instrutores = response.data;
      });
    };	

  	$scope.sucesso = function() {
  		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
  	}

    swal.setDefaults({
      confirmButtonColor: '#3399FF'
    });
  });
