var dia2 = angular.module('dia2', []);

dia2.controller('mudarData', function ($scope, $filter) {

	$scope.converterData = converterData;

	function converterData() {

	let pattern = '/(\d{2})\/(\d{2})\/(\d{4})/';
    let replace = '$1.$2.$3';
    let dataFormatada = $scope.dataDigitada.replace(pattern, replace);
    console.log(dataFormatada);

    let dataObjeto = new Date(dataFormatada);
    
    $scope.dataObjeto = dataObjeto;
    // $scope.dataPronta = $filter('date')(dataObjeto, 'mediumDate')
  }

});
