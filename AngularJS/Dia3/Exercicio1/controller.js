var app = angular.module('app', []);

app.filter('incluir', function() {
	return function(){
		console.log(nome);
		return instrutores.push({nome: instrutores.nome, sobrenome: sobrenome, idade: idade, email: email, jaDeuAula: jaDeuAula, aula: aula});
	}
})

app.controller('exercicio', function ($scope) {
	
	$scope.instrutores = 
	[{
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
    }];

	$scope.aulas = [
	    'OO',
	    'HTML e CSS',
	    'Javascript',
	    'AngularJS',
	    'Banco de Dados I'
	];
});