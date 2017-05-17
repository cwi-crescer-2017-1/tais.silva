var modulo1 = angular.module('modulo1', []);

modulo1.controller('formularioPkn', function($scope) {
  $scope.pokemon = [{
  nome: '11', 
  tipo: 'Default' 
},
{
  nome: '22', 
  tipo: 'Default2' 
  }]
});

// modulo1.controller('formularioPkn', ['$scope', function(model) {
//   model.pokemon = {
//   nome: 'Joao', 
//   tipo: 'Default' 
//   }
// }]);