angular
	.module('app')
	.controller('AdminstrativoController', function ($scope, authService, autoresService, livrosService, toastr) {
		$scope.controller = 'AdminstrativoController';
		$scope.auth = authService;
		$scope.autores = [];
		$scope.incluirAutor = incluirAutor;
		$scope.incluirLivro = incluirLivro;
		$scope.editarLivro = editarLivro;
		$scope.editarAutor = editarAutor;
		$scope.excluirLivro = excluirLivro;
		$scope.excluirAutor = excluirAutor;
		$scope.usuarioAtual = authService.getUsuario();
		carregarAutores();

		$scope.mensagem = {
		colaborador: 'Mensagem incrível para o usuário AUTENTICADO',
		administrador: 'Mensagem incrível para o usuário ADMINISTRADOR',
		};

		function carregarAutores(){
			autoresService
				.carregarAutores()
				.then(function(response){
				$scope.autores = response.data.dados;
			})
		}

		function incluirAutor(nome) {
			if ($scope.formAutores.$valid) {
				autoresService
					.adicionarAutor(nome)
					.then(function (response) {
                        toastr.success('Cadastro realizado com sucesso.', 'Autor incluído!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function incluirLivro(livro) {
			if ($scope.formLivros.$valid) {
				livrosService
					.adicionarLivro(livro)
					.then(function (response) {
						toastr.success('Cadastro realizado com sucesso.', 'Livro incluído!');
					}, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');	
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function editarAutor(id, autor) {
			if ($scope.formAutores.$valid) {
				autoresService
					.editarAutor(id, autor)
					.then(function (response) {
                        toastr.success('Alteração realizada com sucesso.', 'Autor atualizado!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function editarLivro(isbn, livro) {
			if ($scope.formLivros.$valid) {
				livrosService
					.editarLivro(isbn, livro)
					.then(function (response) {
                        toastr.success('Alteração realizada com sucesso.', 'Autor atualizado!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function excluirAutor(id, autor) {
			if ($scope.formAutores.$valid) {
				autoresService
					.excluirAutor(id, autor)
					.then(function (response) {
                        toastr.success('Exclusão realizada com sucesso.', 'Autor excluído!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function excluirLivro(isbn, livro) {
			if ($scope.formLivros.$valid) {
				livrosService
					.excluirLivro(isbn, livro)
					.then(function (response) {
                        toastr.success('Exclusão realizada com sucesso.', 'Livro excluído!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function revisarLivro(isbn, livro) {
			livro.IdRevisor = usuarioAtual.Id;
			if ($scope.formLivros.$valid) {
				livrosService
					.revisarLivro(isbn, livro)
					.then(function (response) {
                        toastr.success('Revisão realizada com sucesso.', 'Livro revisado!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function publicarLivro(isbn, livro) {
			livro.IdPublicador = usuarioAtual.Id;
			if ($scope.formLivros.$valid) {
				livrosService
					.publicarLivro(isbn, livro)
					.then(function (response) {
                        toastr.success('Publicação realizada com sucesso.', 'Livro publicado!');
	                }, function(response){
						toastr.error('Ocorreu um erro ao adicionar.', 'Depois tente novamente!');
					})
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}
	});
