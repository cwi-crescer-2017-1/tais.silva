
javascript: (function () { $('input, textarea').val('something');
 $('[type=email]').val('something@something.com.br');
 $('[type=number]').val(18);
 $('[type=checkbox]').prop('checked', true);
 $('select').val('OO');
 })();

$scope.preencher = functin 

 $scope.PesquisarCpf = function (cpf) {
    $http.post("http://GetCpf.php", {"cpf": cpf,}).
               success(function(data, status, headers, config){
                 $scope.contratos = data;
               }).error(function(data, status, headers, config){
                 location.href="#/Cliente"

               });
}