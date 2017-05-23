angular
  .module('app')
  .controller('HomeController', function ($scope, $rootScope, serviceAulas, serviceInstrutores) {
  	$scope.controller = 'HomeController';	
  	$scope.sucesso = function() {
  		return swal("Pronto!", "Ação realizada com Sucesso!", "success");		
  	}

  	function gerarProximoId(lista){
  		return lista.length !== 0 ? lista[lista.length-1].id + 1 : 0;
  	}	

  	$scope.aulas = serviceAulas.list().then(function (response) {
            $scope.aulas = response.data;
      });

      $scope.aulas = serviceInstrutores.list().then(function (response) {
            $scope.instrutores = response.data;
      });
  });




  // // Inicia todas as divs Accordion fechadas
  // $('[id^=collapse]').collapse('hide');


  // swal.setDefaults({
  //     confirmButtonColor: '#3399FF'
  // });