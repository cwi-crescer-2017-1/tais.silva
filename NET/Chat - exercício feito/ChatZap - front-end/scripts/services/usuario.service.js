chatzap.factory('UsuarioService', function($http) {

    var urlUsuario = 'http://localhost:57870/api/Usuarios';

    function carregarUsuarios() {
		return $http.get(urlUsuario);
	}

    function adicionarUsuario(usuario) {
        return $http.post(urlUsuario, usuario);
    }

    return {
        adicionar: adicionarUsuario,
        carregar:  carregarUsuarios	
    };
});