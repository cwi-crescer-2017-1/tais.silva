var app = angular.module('app', []);

app.controller('exercicio', function ($scope) {
	
	$scope.incluir = function (novoInstrutor) {
		if ($scope.formInstrutores.$valid) {
			$scope.instrutores.push(angular.copy(novoInstrutor));
			$scope.novoInstrutor = {};		
	 	}
	 };


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