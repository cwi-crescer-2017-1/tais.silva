angular
  .module('app')
  .controller('HomeController', function ($scope, aulasService, instrutoresService) {
  	$scope.controller = 'HomeController';	

  	$scope.sucesso = function() {
  		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
  	}

  	$scope.aulas = aulasService.listar().then(function (response) {
            $scope.aulas = response.data;
    });

    $scope.aulas = instrutoresService.listar().then(function (response) {
            $scope.instrutores = response.data;
    });
  });




  // // Inicia todas as divs Accordion fechadas
  // $('[id^=collapse]').collapse('hide');


  // swal.setDefaults({
  //     confirmButtonColor: '#3399FF'
  // });