angular
    .module('app')
    .factory('LivrosService', function($http) {

        var urlLivros = 'http://localhost:54198/api/livros';

        function carregar() {
            return $http.get(urlLivros);
        };

        function carregarLivros(parametros) {
            return $http({
                 url: urlLivros,
                 method: 'GET',
                 params: parametros
               });
        };

        function carregarLancamentos() {
            return $http.get(`${urlLivros}/lancamentos`);
        };

        function adicionarLivro(livro) {
            return $http.post(urlLivros, livro);
        };

        return {
            carregar: carregar,
            carregarLivros: carregarLivros,
            carregarLancamentos: carregarLancamentos,
            adicionarLivro: adicionarLivro
        };
    });