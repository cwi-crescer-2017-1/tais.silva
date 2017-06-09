angular
	.module('app')
	.controller('AdministrativoController', function ($scope, $uibModal, authService, administrativoService, locacaoService, toastr) {
		$scope.auth = authService;		
		$scope.usuarioAtual = authService.getUsuario();
		$scope.operador = authService.possuiPermissao("Operador");
		$scope.gerente = authService.possuiPermissao("Gerente");
		$scope.registrar = registrar;
		$scope.clientePego = {};
		$scope.relatorioMensal = {};
		$scope.relatorioAtrasados = {};
		$scope.locacao = {};
		$scope.orcamentoFeito = null;
		$scope.locacaoDevolver = null;		

		$scope.carregarCliente = function(cpf){
			if ($scope.formCpf.$valid) {
				administrativoService
					.carregarCliente(cpf)
					.then(function(response){
						$scope.clientePego = response.data.dados;
						verificarDevolucaoPendente(clientePego.Id);
						toastr.success('Cadastro encontrado com sucesso.', 'Dados do cliente abaixo!');
		            }, function(response){
						toastr.error('Cliente não cadastrado', 'Cadastre abaixo!');
					});
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}

		function registrar(cliente){
			if ($scope.formCadastro.$valid) {
				cliente.dataNascimento = new Date(cliente.dataNascimento).toLocaleString();
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

		$scope.orcamento = function(locacao){
			if ($scope.formLocacao.$valid) {
				locacaoService
					.orcamento(locacao)
					.then(function(response){
						$scope.orcamentoFeito = response.data.dados;
						toastr.success('Orçamento realizado com sucesso.', 'Orçamento solicitado!');
		            }, function(response){
							toastr.error('Ocorreu um erro ao orçar.', 'Depois tente novamente!');
					});
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Depois tente novamente!');
			}
		}	

		$scope.confirmarLocacao = function(locacao){		
			locacaoService
				.confirmar(locacao)
				.then(function(response){
					toastr.success('Locação realizada com sucesso.', 'Locação realizada!');
	            }, function(response){
						toastr.error('Ocorreu um erro ao locar.', 'Depois tente novamente!');
				});
		}

		$scope.verificarDevolucaoPendente = function(id){
			locacaoService
				.listaLocacaoCpf(id)
				.then(function(response){
					$scope.locacaoDevolver = response.data.dados;
	            });
		}

		$scope.devolverLocacao = function(locacaoDevolver){
			locacaoService
				.devolver(locacaoDevolver)
				.then(function(response){
					toastr.success('Devolução realizada com sucesso.', 'Devolução realizada!');
	            }, function(response){
						toastr.error('Ocorreu um erro ao locar.', 'Depois tente novamente!');
				});
		}
		
		$scope.carregarRelatorioMensal = function (data){
			if(!data){
				return
			}
			locacaoService.relatorioMensal(data).then(function(response){
				console.log(response.data.dados);
				$scope.relatorioMensal = response.data.dados;
				$uibModal.open({
					backdrop: true,
					templateUrl: 'myModalContent.html',
					controller: function($scope, $uibModalInstance) {
						$scope.relatorioMensal = response.data.dados;
						$scope.cancel = function(){
							$uibModalInstance.dismiss();
						}
					}
				})
			});
		};

		$scope.carregarRelatorioAtrasados = function (){			
			locacaoService.relatorioAtrasados().then(function(response){
				$scope.relatorioAtrasados = response.data.dados;
				$uibModal.open({
					backdrop: true,
					templateUrl: 'myModalContent2.html',
					controller: function($scope, $uibModalInstance) {
						$scope.relatorioAtrasados = response.data.dados;
						$scope.cancel = function(){
							$uibModalInstance.dismiss();
						}
					}
				})
			});
		};
	});
