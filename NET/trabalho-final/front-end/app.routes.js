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
              templateUrl: 'login/login.html',
              resolve: {
                autenticado: function (authService, $q, $location) {
                  var deferred = $q.defer();

                  if(authService.isAutenticado()) {
                    $location.path("/administrativo");
                    deferred.reject();
                  } else {
                    deferred.resolve();
                  }

                  return deferred.promise;
                }
              }
            })

                // privado
            .when('/administrativo', {
              controller: 'AdministrativoController',
              templateUrl: 'administrativo/administrativo.html',
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