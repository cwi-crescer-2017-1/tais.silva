editora.factory('LivrosService', function($http) {

    var urlLivros = 'http://localhost:54198/api/livros';

    function carregarLivros() {
        return $http.get(urlLivros);
    };

    function carregarLancamentos() {
        return $http.get(`${urlLivros}/lancamentos`);
    };

    function adicionarLivro(livro) {
        return $http.post(urlLivros, livro);
    };

    return {
        carregarLivros,
        carregarLancamentos,
        adicionarLivro
    };
});