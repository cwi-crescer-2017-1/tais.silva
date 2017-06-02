editora.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'templates/home.html'
        })
        // .when('/chat', {
        //     controller: 'ChatController',
        //     templateUrl: 'templates/chat.html'
        // })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'templates/login.html'
        })
        .otherwise({
            redirectTo: '/home'
        });
});