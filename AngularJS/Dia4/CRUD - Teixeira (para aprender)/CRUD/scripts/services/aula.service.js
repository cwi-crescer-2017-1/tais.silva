crud.factory('AulaService', function ($http) {
    //Aqui vou colocar todos os métodos relacionados a aulas $get, $post, etc
    var urlAulas = 'http://10.99.4.125:3000/aula';

    function getTodasAsAulas() {
        return $http.get(urlAulas);
    };

    function adicionarAula(aula){
        return $http.post(urlAulas, aula);
    }

    return {
        findAll: getTodasAsAulas,
        add: adicionarAula
    };
});