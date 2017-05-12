// Exercício 1
function daisyGame(num){
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
function fiboSum(num) {
	var ant = 1;
	var soma = 1;
	for (var i = 1; i <= num; i++) {
		soma = ant + soma;
		ant = soma - ant;
	}
	console.log(soma-1);
}

fiboSum(7);
// 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)

// Exercício 6
function queroCafe(mascada, precos) {
	var array = [];
	var add = 0;	
	for (var i = 0; i < precos.length; i++) {
		if(precos[i] <= mascada) {			
			array[add] = precos[i];			
			add = add + 1;
		}
	}
/*	console.log(array)
	var novaArray = [];
	novaArray[0] = array[0];
	for (var a = 0; a < array.length; a++) {
		for (var b = 0; b < array.length; b++) {
			if(array[a] > array[b] && novaArray[a] > array[b]) {
				novaArray[a] = array[b];
			}
		}
	}

	console.log(novaArray.toString());*/

	console.log(array.sort().toString());
}

queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
// '1.15,2.12,3.11'

