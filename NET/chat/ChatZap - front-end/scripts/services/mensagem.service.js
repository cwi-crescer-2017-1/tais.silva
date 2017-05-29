chatzap.factory('MensagemService', function($http) {

    var urlMensagem = 'http://localhost:57870/api/Mensagens';

    function carregarMensagens() {
        return $http.get(urlMensagem);
    };

    function adicionarMensagem(mensagem) {
        return $http.post(urlMensagem, mensagem);
    };

    return {
        carregar: carregarMensagens,
        adicionar: adicionarMensagem
    };
});