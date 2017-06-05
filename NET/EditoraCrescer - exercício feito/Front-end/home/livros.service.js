angular
    .module('app')
    .factory('livrosService', function($http) {

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

        function editarLivro(isbn, livro) {
            return $http.put(`${urlLivros}/${isbn}`, livro);
        };

        function excluirLivro(isbn) {
            return $http.delete(`${urlLivros}/${isbn}`);
        };

        function revisarLivro(isbn, livro) {
            return $http.put(`${urlLivros}/${isbn}/revisar`, livro);
        };

        function publicarLivro(isbn, livro) {
            return $http.put(`${urlLivros}/${isbn}/publicar`, livro);
        };

        return {
            carregar: carregar,
            carregarLivros: carregarLivros,
            carregarLancamentos: carregarLancamentos,
            adicionarLivro: adicionarLivro,
            editarLivro: editarLivro,
            excluirLivro: excluirLivro,
            revisarLivro: revisarLivro,
            publicarLivro: publicarLivro
        };
    });