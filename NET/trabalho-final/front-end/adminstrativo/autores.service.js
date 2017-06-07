angular
    .module('app')
    .factory('administrativoService', function($http) {

        var urlAdministrativo = 'http://localhost:54198/api/autores';

        function carregarAutores() {
            return $http.get(urlAutores);
        };

        function adicionarAutor() {
            return $http.get(urlAutores);
        };

        function editarAutor(id, novoAutor) {
            return $http.put(`${urlAutores}/${id}`, novoAutor);
        };

        function excluirAutor(id) {
            return $http.delete(`${urlAutores}/${id}`);
        };

        return {
        	carregarAutores: carregarAutores,
        	adicionarAutor: adicionarAutor,
            editarAutor: editarAutor,
            excluirAutor: excluirAutor
        };
    });