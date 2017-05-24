angular
  .module('app')
  .factory('instrutoresService', function ($http) {

    let urlBase = 'http://localhost:3000/instrutor';

  function listar() {
    return $http.get(urlBase);
  };

  function alterar(instrutor) {
    return $http.put(urlBase + '/' + instrutor.id, instrutor);
  };
  
  function incluir(instrutor) {
    return $http.post(urlBase, instrutor);
  };

  function excluir(instrutor) {
    return $http.delete(urlBase + '/' + instrutor.id);
  };

  return {

    listar: listar,
    alterar: alterar,
    incluir: incluir,
    excluir: excluir
  }
  });