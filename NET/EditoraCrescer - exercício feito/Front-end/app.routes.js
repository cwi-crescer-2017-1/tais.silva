angular
    .module('app')
    .config(function($routeProvider) {
        $routeProvider
            .when('/home', {
                controller: 'HomeController',
                templateUrl: 'home/home.html'
            })
            .when('/login', {
                  controller: 'LoginController',
                  templateUrl: 'login/login.html'
                })

                // privado
            .when('/privado', {
              controller: 'PrivadoController',
              templateUrl: 'privado/privado.html',
              resolve: {

                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              }
            })
            .otherwise({
                redirectTo: '/home'
            });
    });