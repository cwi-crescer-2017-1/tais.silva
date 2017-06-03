angular
    .module('app')
    .factory('LoginService', function($http) {

        var urlUsuarios = 'http://localhost:54198/api/usuario';

        function carregar() {
            return $http.get(urlUsuarios);
        };

        return {
            carregar: carregar
        };
    });