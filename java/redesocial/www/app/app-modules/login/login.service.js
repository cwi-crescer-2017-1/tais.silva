angular
    .module('app')
    .factory('LoginService', function($http) {

        var urlUsuarios = 'http://localhost:9090/api/usuario';

        function carregarUsuario(email) {
            return $http.get(`${urlUsuarios}/email/${email}`);
        };

        function salvarUsuario(usuario) {
            return $http.post(urlUsuarios, usuario);
        };
        
        function atualizar(usuario) {
            return $http.put(urlUsuarios, usuario);
        };

        function resetarSenha() {
            return $http.post(`$(urlUsuarios)/resetarsenha`);
        };

        return {
            carregar: carregarUsuario,
            salvar: salvarUsuario,
            atualizar: atualizar
        };
    });