var dia1 = angular.module('dia1', []);

dia1.controller('formularioPkn', ['$scope', function(model) {

	model.pokemon = 
	[{
		nome: 'Bulbasaur', 
		tipo: 'Grass' 
	},
	{
		nome: 'Ivysaur', 
		tipo: 'Poison' 
	},
	{
		nome: 'Charmander', 
		tipo: 'Fire' 
	},
	{
		nome: 'Charizard', 
		tipo: 'Flying' 
	},
	{
		nome: 'Squirtle', 
		tipo: 'Water' 
	}]

}]);



// dia1.controller('formularioPkn', function($scope) {
//   $scope.pokemon = [{
//   nome: '11', 
//   tipo: 'Default' 
// },
// {
//   nome: '22', 
//   tipo: 'Default2' 
//   }]
// });
