angular
    .module('app')
    .config(function($routeProvider) {
        $routeProvider
            .when('/home', {
                controller: 'HomeController',
                templateUrl: 'app/app-modules/home/home.html'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'app/app-modules/login/login.html'
            })
            .when('/privado', {
                controller: 'PrivadoController',
                templateUrl: 'app/app-modules/privado/privado.html'
            })
            .when('/perfil', {
                controller: 'PerfilController',
                templateUrl: 'app/app-modules/perfil/perfil.html'
            })
            .when('/pesquisar', {
                controller: 'PesquisarController',
                templateUrl: 'app/app-modules/pesquisar/pesquisar.html'
            })
            .when('/amigos', {
                controller: 'AmigosController',
                templateUrl: 'amigos.html'
            })
            .when('/detalhado/:id', {
                controller: 'DetalhadoController',
                templateUrl: 'detalhado.html'
            })

                // privado
            .when('/privado', {
              controller: 'PrivadoController',
              templateUrl: 'app/app-modules/privado/privado.html',
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