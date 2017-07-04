angular
    .module('app')
    .factory('PrivadoService', function($http) {

        var urlAmizades = 'http://localhost:9090/api/amizade';

        function carregarAmizades() {
            return $http.get(`${urlAmizades}/todos`);
        };

        function carregarAmizadesPendentes() {
            return $http.get(`${urlAmizades}/pendentes`);
        };

        function carregarSolicitacoesPendentes() {
            return $http.get(`${urlAmizades}/solicitacoespendentes`);
        };

        function carregarAmizadesAceitas() {
            return $http.get(`${urlAmizades}/aceitas`);
        };

        function salvarAmizade(idSolicitado) {
            return $http.post(urlAmizades, idSolicitado);
        };
        
        function aceitarAmizade(idAmizade) {
            return $http.put(`${urlAmizades}/aceitar`, idAmizade);
        };

        function rejeitarAmizade(idAmizade) {
            return $http.delete(`${urlAmizades}/rejeitar/${idAmizade}`);
        };

        return {
            carregarAmizades: carregarAmizades,
            carregarAmizadesPendentes: carregarAmizadesPendentes,
            carregarPendentes: carregarSolicitacoesPendentes,
            carregarAceitas: carregarAmizadesAceitas,
            salvarAmizades: salvarAmizade,
            aceitar: aceitarAmizade,
            rejeitar: rejeitarAmizade
        };
    });