// Exercício 1
function daisyGame(num){
	// Interpolação de string 
	//return `Love me${ numero % 2 !== 0 ? '' : ' not' }`;
	/*var impar = % 2 !== 0;
	return `Love me${ impar ? '' : ' not' }`*/
	// return num % 2 !== 0 ? 'Love me' : 'Love me not';
	var resposta;
	if(num%2 == 0) { 
		resposta = "Love me  not";
	} else { resposta = "Love me"; };

	return console.log(resposta);
}

daisyGame(4);

// Exercício 2
function maiorTexto(array) {
	var maior = 0;
	for(var i = 0; i < array.length; i++) {		
		if (array[maior].length < array[i].length) {
			maior = i;
		}
	}
	return console.log(array[maior]);
}

maiorTexto(["agua", "chuva", "sapatear"]);

// Exercício 3
function imprime(array, funcao) {
	if(typeof(funcao) !== "function") {
		console.log("TypeError: number is not a function");
		return;
	}if(typeof(funcao) === "function") {
		var instrutor;
		for(var i = 0; i < array.length; i++) {
			instrutor = array[i]; 
			funcao(instrutor);
		}
	}
} 

imprime(
  // primeiro parâmetro: array
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
  // segundo parâmetro: função
  function(instrutor) {
   console.log('olá querido instrutor:', instrutor);
  }
);

imprime(
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.14 );

// Exercício 4
function adicionar(a) {
	return function(b){
		console.log(a + b);	
	}
} 

adicionar(3)(4); // 7
adicionar(5642)(8749); // 14391

// Exercício 5
/*function fiboSum(num) {
	var ant = 1;
	var soma = 1;
	for (var i = 1; i <= num; i++) {
		soma = ant + soma;
		ant = soma - ant;
	}
	return soma-1;
}*/

function fibonacci(n) {	
	if (n === 1 || n ===2) return 1;
	return fibonacci(n-1) + fibonacci(n-2);
}

function fiboSum(n) {
	if (n === 1) { return 1;}
	return fibonacci(n) + fiboSum(n-1);
}

console.log(fiboSum(7));
// 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)

// Exercício 6
function queroCafe(mascada, precos) {
/*	Pq o Bernardo tinha pedido na mão:
	let array = [];
	let add = 0;	
	for (var i = 0; i < precos.length; i++) {
		if(precos[i] <= mascada) {			
			array[add] = precos[i];			
			add = add + 1;
		}
	}*/
/*	let array = [];
	precos.forEach(p => { if (p <= mascada) array.push(p)});
	console.log(array.sort((a,b) => a-b).toString());*/

	

	return precos
		.filter(a => a <= mascada)
		.sort((a,b) => a-b)
		.join(',')
}

console.log(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));
// '1.15,2.12,3.11'

