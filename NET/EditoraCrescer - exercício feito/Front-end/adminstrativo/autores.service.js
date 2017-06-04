angular
    .module('app')
    .factory('AutoresService', function($http) {

        var urlAutores = 'http://localhost:54198/api/autores';

        function carregar() {
            return $http.get(urlAutores);
        };

        return {
        };
    });