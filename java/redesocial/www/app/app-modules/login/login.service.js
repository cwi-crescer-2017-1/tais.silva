angular
    .module('app')
    .factory('LoginService', function($http) {

        var urlUsuarios = 'http://localhost:9090/api/usuario';

        function carregarUsuario() {
            return $http.post(`$(urlUsuarios)/usuario`);
        };

        function salvarUsuario(usuario) {
            return $http.post(urlUsuarios, usuario);
        };
        
        function resetarSenha() {
            return $http.post(`$(urlUsuarios)/resetarsenha`);
        };

        return {
            carregar: carregarUsuario,
            salvar: salvarUsuario,
            resetar: resetarSenha
        };
    });