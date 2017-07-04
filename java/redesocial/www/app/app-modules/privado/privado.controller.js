angular
	.module('app.core')
	.controller('PrivadoController', function ($scope, authService, toastr, LoginService, PrivadoService, $routeParams, PostsService) {

		if(!authService.isAutenticado()){
			$location.path('/home');
		}

		$scope.usuario = null;
		logado = null;
		carregarLogado();

		function carregarLogado(){
			logado = authService.getUsuario().username;
		}

		carregarUsuario();	

		function carregarUsuario(){
			LoginService
				.carregar(logado)
				.then((r) => { $scope.usuario = r.data; console.log(r.data); $scope.usuario.senha = null}),
				(r)=> {toastr.warning('Erro na atualização.', 'Depois tente novamente!');};
		}

		// Salvar posts
		$scope.postSalvo = null;
		$scope.salvarPost = salvarPost;

		function salvarPost(post){
			post.usuario = $scope.usuario;
			post.dataAtual = formatarData(new Date());
			console.log("post usuario", post)
			PostsService
				.salvarPost(post)
				.then((r) => { console.log("post antes",r.data); $scope.postSalvo = null; carregarPosts(); console.log("post depois", $scope.postSalvo);})
				.catch(error => console.log(error))
		}

		function formatarData(data){
			var myDate = new Date(data);
			return ('0' + myDate.getDate()).slice(-2) +  "/" + ('0' + (myDate.getMonth() + 1)).slice(-2) + "/" + myDate.getFullYear() + " " + ('0' + myDate.getHours()).slice(-2) + ":" + ('0' + myDate.getMinutes()).slice(-2) + ":" + ('0' + myDate.getSeconds()).slice(-2);	
		}
		// Fim salvar posts

		// Solicitações de amizade
		$scope.solicitantes = null;
		carregarSolicitantes();
		
		function carregarSolicitantes() {	
			PrivadoService
				.carregarAmizadesPendentes()
				.then((r)=> { 
					$scope.solicitantes = r.data; 
					console.log("solitantes:", r.data);
				})
		}; 

		$scope.aceitar = (idAmizade) => {
		PrivadoService
			.aceitar(idAmizade)
			.then((r) => { toastr.success('Sucesso.', 'Agora vocês são amigos!'); carregarSolicitantes();}),
			(r)=> {toastr.warning('Erro ao adicionar.', 'Depois tente novamente!');};
		}

		$scope.rejeitar = (idAmizade) => {
		PrivadoService
			.rejeitar(idAmizade)
			.then((r) => { toastr.success('Amizade rejeitada.', 'Vocês são serão amigos!'); carregarSolicitantes();}),
			(r)=> {toastr.warning('Erro ao rejeitar.', 'Depois tente novamente!');};
		}
		// Fim solicitações de amizade

		// Solicitações pendentes
		$scope.pendentes = null;
		carregarPendentes();
		
		function carregarPendentes() {	
			PrivadoService
				.carregarPendentes()
				.then((r)=> { 
					$scope.pendentes = r.data; 
					console.log("pendentes:", r.data);
				})
		}; 
		// Fim solicitações pendentes

		// Carregar posts
		$scope.posts = null;
		carregarPosts();
		function carregarPosts(){
			PostsService
				.carregarPosts()
				.then((r) => { 
					$scope.posts = r.data; console.log("oi", r.data);
					$scope.posts.forEach(function(post) {
						contador(post);						
						carregarReacoes(post);
					});				
				})
				.catch(error => console.log(error));
		}
		// Fim carregar posts

		// Reagir 
		$scope.contador = null;
		//$scope.reagido = null;
		$scope.reagir = reagir;	
		function contador(post) {	
			PostsService
				.carregarContador(post.id)
				.then((r)=> { 
					post.quantidadeReacoes = r.data; 
				})
		};

		function carregarReacoes(post) {	
			PostsService
				.carregarReagir(post.id)
				.then((r)=> { 
					post.reacoes = r.data;
					post.reagido = false;
					post.reacoes.forEach(i => {
						if(i.usuario.id === $scope.usuario.id){
							post.reagido = true; 
						}else {
							post.reagido = false;
						}
					}); 	
				})
		};

		function reagir(post) {
			var reacao = {};
			reacao.post = post;
			reacao.dataAtual = formatarData(new Date());
			reacao.usuario = $scope.usuario;
			if(post.reagido === true){
				PostsService
				.removerReagir(post.id)
				.then((r)=> { 
					post.reagido = false; 
				})
			} else {
				PostsService
				.salvarReagir(post.id)
				.then((r)=> { 
					post.reagido = true; 
				})
			}			
		};
		// Fim reagir

		//Logout
		$scope.logout = function () {
				authService.logout();
				toastr.success('Logout realizado com sucesso.', 'Você está fora!');
		};
	});