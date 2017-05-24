crud.controller('ListaController', function ($scope, AulaService, InstrutorService, toastr) {
    $scope.aulas = [];
    $scope.instrutores = [];

    pegarDados(); //Cada vez que a controller é chamada, ela pega os dados pelo service


    function pegarDados(){
        InstrutorService.findAll().then(function(res){
            $scope.instrutores = res.data; // data = dados da requisição
        });
        AulaService.findAll().then(function(res){
            $scope.aulas = res.data; // data = dados da requisição
        });
        var toast = toastr.info('Dados atualizados', 'Informação');
        toastr.refreshTimer(toast, 2000);
    };

    $scope.geraNomeAula = function(numeroAula){
        return $scope.aulas.find(e => e.id === numeroAula);
    };
});
