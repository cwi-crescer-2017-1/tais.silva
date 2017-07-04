angular
    .module('app')
    .factory('PostsService', function($http) {

        var urlPosts = 'http://localhost:9090/api/post';
        var urlReacoes = 'http://localhost:9090/api/reacao';

        function carregarPosts() {
            return $http.get(`${urlPosts}/todos`);
        };
        
        function salvarPost(post) {
            return $http.post(urlPosts, post);
        };

        function carregarReagir(idPost) {
            return $http.get(`${urlReacoes}/listar/${idPost}`);
        };

        function carregarContador(idPost) {
            return $http.get(`${urlReacoes}/count/${idPost}`);
        };
                
        function salvarReagir(reacao) {
            return $http.post(urlReacoes, reacao);
        };

        function removerReagir(id) {
            return $http.delete(`${urlReacoes}/${id}`);
        };

        return {
            carregarPosts: carregarPosts,
            salvarPost: salvarPost,
            carregarReagir: carregarReagir,
            carregarContador: carregarContador,
            salvarReagir: salvarReagir,
            removerReagir: removerReagir
        };
    });