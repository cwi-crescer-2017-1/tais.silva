crud.factory('AulaService', function ($http) {
    //Aqui vou colocar todos os métodos relacionados a aulas $get, $post, etc
    var urlAulas = 'http://localhost:3000/aula';

    function getTodasAsAulas() {
        return $http.get(urlAulas);
    };

    return {
        findAll: getTodasAsAulas,
    };
});