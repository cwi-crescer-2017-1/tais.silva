angular
    .module('app')
    .factory('administrativoService', function($http) {

        var urlCliente = 'http://localhost:64006/api/cliente';
        var urlProduto = 'http://localhost:64006/api/produto';
        var urlPacote = 'http://localhost:64006/api/pacote';
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

        function carregarProdutoId(id) {
            return $http.get(`${urlProduto}/${id}`);
        };

        function carregarProduto() {
            return $http.get(urlProduto);
        };

        function carregarPacote() {
            return $http.get(urlPacote);
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
            carregarProdutoId: carregarProdutoId,
            carregarProduto: carregarProduto,
            carregarPacoteId: carregarPacoteId,
            carregarPacote: carregarPacote,
            carregarExtraId: carregarExtraId,
            carregarExtra: carregarExtra
        }
    });