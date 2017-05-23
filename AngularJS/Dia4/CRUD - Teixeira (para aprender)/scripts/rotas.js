crud.config(function ($routeProvider) {
    //Rota principal - rota de listas
    $routeProvider
        .when('/aulas', {
            controller: 'AulaController',
            templateUrl: 'templates/aulas.html'
        })
        .when('/instrutores', {
            controller: 'InstrutorController',
            templateUrl: 'templates/instrutores.html'
        })
        .when('/listas', {
            controller: 'ListaController',
            templateUrl: 'templates/listas.html'
        })
        .otherwise({
            redirectTo: '/listas'
        });
});