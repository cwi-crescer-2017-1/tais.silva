angular
	.module('app')
	.controller('AdministrativoController', function ($scope, $uibModal, authService, administrativoService, locacaoService, toastr) {
		$scope.auth = authService;		
		$scope.usuarioAtual = authService.getUsuario();
		$scope.operador = authService.possuiPermissao("Operador");
		$scope.gerente = authService.possuiPermissao("Gerente");
		$scope.registrar = registrar;
		$scope.clientePego = null;
		$scope.relatorioMensal = null;
		$scope.relatorioAtrasados = null;
		$scope.locacao = null;
		$scope.orcamentoFeito = null;
		$scope.locacaoDevolver = null;		

		$scope.carregarCliente = function(cpf){
			if ($scope.formCpf.$valid) {
				administrativoService
					.carregarCliente(cpf)
					.then(function(response){
						$scope.clientePego = response.data.dados;						
						verificarDevolucaoPendente($scope.clientePego.Cpf);
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
				console.log("variavel", locacao);
				locacaoService
					.orcamento(locacao)
					.then(function(response){
						console.log("respose", response.data.dados);
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
					debugger
					var locacaoResponse = response.data.dados;
					console.log("locacaoResponse", locacaoResponse.Cliente.Cpf);
					console.log("locacaoResponse", locacaoResponse);
					verificarDevolucaoPendente(locacaoResponse.Cliente.Cpf);
					toastr.success('Locação realizada com sucesso.', 'Locação realizada!');
	            }, function(response){
						toastr.error('Ocorreu um erro ao locar.', 'Depois tente novamente!');
				});
		}

		function verificarDevolucaoPendente(cpf){
			console.log("cpf", cpf);
			locacaoService
				.listaLocacaoCpf(cpf)
				.then(function(response){
					console.log("dentro de verificar", response.data.dados);
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
