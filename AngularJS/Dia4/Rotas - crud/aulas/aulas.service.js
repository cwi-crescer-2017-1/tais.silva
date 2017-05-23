angular
  .module('app')
  .factory('aulasService', function ($http) {

    let urlBase = 'http://localhost:3000';

    function getTodasAsAulas() {
      return $http.get(urlBase + '/aula');
    };

    function getAulaPorId(id) {
      return $http.get(urlBase + '/aula' + '/' + id);
    };

    function atualizar(aula) {
      return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
    };

    function criar(aula) {
      aula.id = ++idAtual;
      aulas.push(angular.copy(aula));
    };

    return {
      list: getTodasAsAulas,
      findById: getAulaPorId,
      update: atualizar,
      create: criar
    };
  });