chatzap.config(function($routeProvider) {
    $routeProvider
        .when('/chat', {
            controller: 'ChatController',
            templateUrl: 'templates/chat.html'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'templates/login.html'
        })
        .otherwise({
            redirectTo: '/login'
        });
});