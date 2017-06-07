angular
    .module('app')
    .factory('LoginService', function($http) {

        var urlUsuarios = 'http://localhost:54198/api/funcionario';

        function carregarUsuario() {
            return $http.post(`$(urlUsuarios)/usuario`);
        };

        function criarUsuario() {
            return $http.post(`$(urlUsuarios)/registrar`);
        };
        
        function resetarSenha() {
            return $http.post(`$(urlUsuarios)/resetarsenha`);
        };

        return {
            carregar: carregarUsuario,
            criar: criarUsuario,
            resetar: resetarSenha
        };
    });