angular
    .module('app')
    .factory('RevisoresService', function($http) {

        var urlRevisores = 'http://localhost:54198/api/revisores';

        function carregar() {
            return $http.get(urlRevisores);
        };

        return {
        };
    });