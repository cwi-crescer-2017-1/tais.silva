crud.controller('ListaController', function ($scope, AulaService, InstrutorService) {
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
    };

    $scope.geraNomeAula = function(numeroAula){
        return $scope.aulas.find(e => e.id === numeroAula);
    };
});
