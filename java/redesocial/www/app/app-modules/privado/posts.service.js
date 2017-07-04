angular
    .module('app')
    .factory('PostsService', function($http) {

        var urlPosts = 'http://localhost:9090/api/post';

        function carregarPosts() {
            return $http.get(urlPosts);
        };

        return {
            carregarPosts: carregarPosts
        };
    });