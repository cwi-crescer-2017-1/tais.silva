crud.controller('AulaController', function ($scope, AulaService, toastr) {
    $scope.aulas = [];

    function pegarDados() {
        AulaService.findAll().then(function (res) {
            $scope.aulas = res.data; // data = dados da requisição
        });
    };

    function geraProximoId() {
        return $scope.aulas.length === 0 ? 1 : $scope.aulas[length - 1] + 1;
    }

    function verificaNome(nome) {
        return $scope.aulas.some(aula => aula.nome.toUpperCase() === nome.toUpperCase());
    }

    $scope.validar = function(nome){
         nome = nome || "";
         $scope.formAddAula.nome.$setValidity("duplicado", !verificaNome(nome));
    }

    $scope.adicionarAula = function (novaAula) {
        if ($scope.formAddAula.$valid) {
            var aula = angular.copy(novaAula);
            aula.id = geraProximoId();
            AulaService.add(aula).then(function () {
                var a = toastr.success('Aula adicionada com sucesso!', 'Mensagem');
                toastr.refreshTimer(a, 2000);
                $scope.add = {};
                $scope.formAddAula.$setPristine();
                $scope.formAddAula.$setUntouched();
                pegarDados();
            }, function () {
                var b = toastr.warning('Ocorreu um erro ao adicionar, tente novamente!', 'Mensagem');
                toastr.refreshTimer(b, 2000);
            });
        }
    };

    pegarDados();
});