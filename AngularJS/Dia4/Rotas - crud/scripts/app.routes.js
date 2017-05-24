angular.module('app')
  .config(function ($routeProvider) {

    $routeProvider
      .when('/home', {
        controller: 'HomeController',
        templateUrl: 'home/home.html'
      })
      .when('/aulas', {
        controller: 'AulasController',
        templateUrl: 'aulas/aulas.html'
      })
      .when('/instrutores', {
        controller: 'InstrutoresController',
        templateUrl: 'instrutores/instrutores.html'
      })
      .otherwise({redirectTo: '/home'});
  });

 