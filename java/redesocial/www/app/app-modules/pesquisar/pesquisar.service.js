angular
    .module('app')
    .factory('PesquisarService', function($http) {

        var urlUsuarios = 'http://localhost:9090/api/usuario';

        function carregar() {
            return $http.get(`${urlUsuarios}/listar`);
        };

        return {
            carregar: carregar
        };
    });