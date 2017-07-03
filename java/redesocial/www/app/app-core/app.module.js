angular
    .module('app.core', [
        'ngRoute',
        'auth',
        'ui.bootstrap',
        'ngAnimate',
        'toastr',
        'ngStorage',
        'luegg.directives',
        'ui.utils.masks'        
    ]);

angular
    .module('app', [
        'app.core'
    ]);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('app')
		.constant('authConfig', {

			// Obrigatória - URL da API que retorna o usuário
			//urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
			urlUsuario: 'http://localhost:9090/api/usuario',

			// Obrigatória - URL da aplicação que possui o formulário de login
			urlLogin: '/login',

			// Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
			urlPrivado: '/privado',

			// Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
			urlLogout: '/home'
		});