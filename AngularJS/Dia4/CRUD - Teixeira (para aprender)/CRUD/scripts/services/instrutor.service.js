crud.factory('InstrutorService', function ($http) {
    //Aqui vou colocar todos os métodos relacionados a instrutores $get, $post, etc
    var urlInstrutores = 'http://10.99.4.125:3000/instrutor';

    function getTodosOsInstrutores() {
        return $http.get(urlInstrutores);
    };

    return {
        findAll: getTodosOsInstrutores
    };
});