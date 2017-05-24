// angular
//   .module('app')
//   .factory('instrutoresService', function ($http) {

//     let urlBase = 'http://localhost:3000';

//     function getTodosOsinstrutores() {
//       return $http.get(urlBase + '/instrutor');
//     };

//     function getinstrutorPorId(id) {
//       return $http.get(urlBase + '/instrutor' + '/' + id);
//     };

//     function atualizar(instrutor) {
//       return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
//     };

//     function criar(instrutor) {
//       instrutor.id = ++idAtual;
//       instrutores.push(angular.copy(instrutor));
//     };

//     return {
//       list: getTodosOsinstrutores,
//       findById: getAulaPorId,
//       update: atualizar,
//       create: criar
//     };
//   });