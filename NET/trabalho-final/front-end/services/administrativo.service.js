angular
    .module('app')
    .factory('administrativoService', function($http) {

        var urlCliente = 'http://localhost:64006/api/cliente';
        var urlPacote = 'http://localhost:64006/api/pacote';
        var urlProduto = 'http://localhost:64006/api/produto';
        var urlExtra = 'http://localhost:64006/api/extra';

        function carregarCliente(cpf) {
            return $http.get(urlCliente, cpf);
        };

        function registrarCliente(cliente) {
            return $http.post(`${urlCliente}/registrar`, cliente);
        };

        function carregarPacoteId(id) {
            return $http.get(`${urlPacote}/${id}`);
        };

        function carregarPacote() {
            return $http.get(urlPacote);
        };

        function carregarProdutoId(id) {
            return $http.get(`${urlProduto}/${id}`);
        };

        function carregarProduto() {
            return $http.get(urlProduto);
        };

        function carregarExtraId(id) {
            return $http.get(`${urlExtra}/${id}`);
        };

        function carregarExtra() {
            return $http.get(urlExtra);
        };

        return {
        	carregarCliente: carregarCliente,
        	registrarCliente: registrarCliente,
            carregarPacoteId: carregarPacoteId,
            carregarPacote: carregarPacote,
            carregarProdutoId: carregarProdutoId,
            carregarProduto: carregarProduto,
            carregarExtraId: carregarExtraId,
            carregarExtra: carregarExtra
        }
    });