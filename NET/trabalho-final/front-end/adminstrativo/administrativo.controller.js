angular
	.module('app')
	.controller('AdministrativoController', function ($scope, $uibModal, authService, administrativoService, locacaoService, toastr) {
		$scope.controller = 'AdministrativoController';
		$scope.auth = authService;		
		$scope.usuarioAtual = authService.getUsuario();
		$scope.operador = authService.possuiPermissao("Operador");
		$scope.gerente = authService.possuiPermissao("Gerente");

		$scope.carregarCliente = function(cpf){
			if ($scope.formCpf.$valid) {
				administrativoService
					.registrarCliente(cpf)
					.then(function(response){
						toastr.success('Cadastro encontrado com sucesso.', 'Dados do cliente abaixo!');
		            }, function(response){
							toastr.error('Cliente não cadastrado', 'Cadastre abaixo!');
					});
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		$scope.registrar = function(cliente){
			if ($scope.formCadastro.$valid) {
				administrativoService
					.registrarCliente(cliente)
					.then(function(response){
						toastr.success('Cadastro realizado com sucesso.', 'Cliente Cadastrado!');
		            }, function(response){
							toastr.error('Ocorreu um erro ao cadastrar.', 'Depois tente novamente!');
					});
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}
		
		
		// $scope.carregarInformacoes = function (isbn){
		// 	livrosService.carregarIsbn(isbn).then(function(response){
		// 		$scope.livroComp = response.data.dados;
		// 		$uibModal.open({
		// 			backdrop: true,
		// 			templateUrl: 'myModalContent.html',
		// 			controller: function($scope, $uibModalInstance) {
		// 				$scope.livroComp = response.data.dados;
		// 				$scope.cancel = function(){
		// 					$uibModalInstance.dismiss();
		// 				}
		// 			}
		// 		})
		// 	});
		// };
	});
