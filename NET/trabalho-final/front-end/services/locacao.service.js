angular
    .module('app')
    .factory('locacaoService', function($http) {

        var urlLocacao = 'http://localhost:64006/api/locacao';

        function carregar() {
            return $http.get(`${urlLocacao}/lista`);
        };

        function carregarPorCpf(cpf) {
            return $http.get(urlLocacao, cpf);
        };

        function orcamento(locacao) {
            return $http.post(`${urlLocacao}/orcamento`, locacao);
        };

        function relatorioMensal(data) {
            return $http.post(`${urlLocacao}/relatorio`, data);
        };

        function relatorioAtrasados() {
            return $http.get(`${urlLocacao}/relatorio`);
        };

        function listaLocacaoCpf(cpf) {
            return $http.get(`${urlLocacao}/listacpf/${cpf}`);
        };

        function confirmar(locacao) {
            return $http.post(`${urlLocacao}/confirmar`, locacao);
        };

        function devolver(locaco) {
            return $http.put(urlLocacao, locacao);
        };

        return {
            carregar: carregar,
            carregarPorCpf: carregarPorCpf,
            orcamento: orcamento,
            relatorioMensal: relatorioMensal,
            relatorioAtrasados: relatorioAtrasados,
            confirmar: confirmar,
            devolver: devolver,
            listaLocacaoCpf: listaLocacaoCpf   
        }   
    });