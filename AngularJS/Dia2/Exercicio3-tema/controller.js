var index = angular.module('index', []);

index.filter('lpad', function($filter) {
	return function(aula){
		return `${ aula.numero.toString().padStart(3, 0) } - ${ $filter('uppercase')(aula.aula) }`;
	}
})

index.filter('mascada', function() {
	return function(nome){
		return nome.replace(/(nunes)/i, '$ $1 $');
	}
})

index.controller('mudarNome', function ($scope) {
	
	$scope.instrutores =  
	[{
	    nome: 'Pedro (PHP)',
	    aula: [{
	      numero: 3,
	      nome: 'HTML e CSS'
	    }]
	  },
	  {
	    nome: 'Zanatta',
	    aula: [{
	      numero: 5,
	      nome: 'AngularJS'
	    }]
	  },
	  {
	    nome: 'Bernardo',
	    aula: [{
	        numero: 1,
	        nome: 'OO'
	      },
	      {
	        numero: 4,
	        nome: 'Javascript'
	      }
	    ]
	  },
	  {
	    nome: 'Nunes',
	    aula: [{
	      numero: 2,
	      nome: 'Banco de Dados I'
	    }]
	  }
	];

	$scope.aulas = [];
	$scope.instrutores
		.forEach(a => a.aula
			.forEach(b => 
				{ $scope.aulas.push({ 'instrutor': a.nome, 'aula': b.nome, 'numero': b.numero}) }));

});