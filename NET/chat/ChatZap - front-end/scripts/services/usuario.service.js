chatzap.factory('UsuarioService', function($http) {

    var urlUsuario = 'http://localhost:57870/api/Usuarios';

    function adicionarUsuario(usuario) {
        return $http.post(urlUsuario, usuario);
    }

    return {
        adicionar: adicionarUsuario
    };
});