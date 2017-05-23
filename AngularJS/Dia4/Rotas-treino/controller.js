let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'aulasController',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores', {
      controller: 'instrutoresController',
      templateUrl: 'instrutores.html'
    })
    .when('/pagina03/:idUrl', {
      controller: 'AulaController',
      templateUrl: 'pagina03.html'
    })
    .when('/pokemon', {
      controller: 'PokemonController',
      templateUrl: 'pokemon.html'
    })
    .otherwise({
      redirectTo: '/aulas'
    });
});

app.controller('aulasController', function ($scope) {
  $scope.controller = 'aulasController';
});

app.controller('instrutoresController', function ($scope) {
  $scope.controller = 'instrutoresController';
});

app.controller('PokemonController', function ($scope, $http) {

  let url = 'http://pokeapi.co/api/v2/pokemon/25/';

  $http.get(url).then(function (response) {
    $scope.name = response.data.name;
  });
});

app.controller('AulaController', function ($scope, $routeParams, aulaService) {
  
  $scope.id = $routeParams.idUrl;
  
  // ações de click 
  $scope.create = create;
  $scope.update = update;

  // Ações executadas quando criar a controller
  findById($scope.id); // buscar aula por id (passado na url)
  list(); // listar aulas

  // Funções internas

  function create(aula) {
    aulaService.create(aula);
  };

  function findById(id) {
    aulaService.findById(id).then(function (response) {
      $scope.aula = response.data;
    });
  };

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

  function update(aula) {
    aulaService.update(aula).then(function () {
      list();  
    });
  };
});
