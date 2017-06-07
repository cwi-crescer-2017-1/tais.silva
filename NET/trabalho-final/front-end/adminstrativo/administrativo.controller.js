angular
	.module('app')
	.controller('AdministrativoController', function ($scope, $uibModal, authService, autoresService, livrosService, toastr) {
		var autores;
		$scope.controller = 'AdministrativoController';
		$scope.auth = authService;
		$scope.autores = [];
		$scope.incluirAutor = incluirAutor;
		$scope.incluirLivro = incluirLivro;
		$scope.editarLivro = editarLivro;
		$scope.editarAutor = editarAutor;
		$scope.excluirLivro = excluirLivro;
		$scope.excluirAutor = excluirAutor;
		$scope.revisar = revisarLivro;
		$scope.publicar = publicarLivro;
		$scope.usuarioAtual = authService.getUsuario();
		$scope.revisor = authService.possuiPermissao("Revisor");
		$scope.publicador = authService.possuiPermissao("Publicador");
		$scope.revisado = revisado;
		carregarAutores();

		$scope.Livros = [];
		$scope.parametros = {
	      quantidadeTrazer: 6,
	      quantidadePular: 0,
	    };   
	    $scope.quantidadeLivros = 0; 
	    $scope.paginaAtual = 0;
	  	carregarLivros($scope.parametros);

	  	function trocarPaginas(){
			$scope.parametros.quantidadePular = ($scope.paginaAtual - 1) * $scope.parametros.quantidadeTrazer;
			carregarLivros($scope.parametros);
		}

		function carregarLivros(parametros){
			livrosService
				.carregarLivros(parametros)
				.then(function(response){
					console.log("Livros", response.data.dados);
					$scope.quantidadeLivros = response.data.quantidade;			
					$scope.Livros = response.data.dados;
				})
		}

		$scope.carregarInformacoes = function (isbn){
			livrosService.carregarIsbn(isbn).then(function(response){
				$scope.livroComp = response.data.dados;
				$uibModal.open({
					backdrop: true,
					templateUrl: 'myModalContent.html',
					controller: function($scope, $uibModalInstance) {
						$scope.livroComp = response.data.dados;
						$scope.cancel = function(){
							$uibModalInstance.dismiss();
						}
						$scope.carregarInformacoes2 = carregarInformacoes2;
					}
				})
			});
		};

		var carregarInformacoes2 = function (livro){	
				debugger
				$uibModal.open({
					backdrop: true,
					templateUrl: 'myModalContent2.html',
					controller: function($scope, $uibModalInstance) {
						$scope.livro = livro;
						$scope.cancel = function(){
							$uibModalInstance.dismiss();
						}
						$scope.autores = autores;
					}
				})
		
		};

		function carregarAutores(){
			autoresService
				.carregarAutores()
				.then(function(response){
				autores = response.data.dados;
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

		function revisado(isbn){
			livrosService.carregarIsbn(isbn).then(function(response){
				$scope.revisado = response.data.dados.DataRevisao != null;
			})
		}
	});
