console.log("Carregou!");
/*
alert("Bem Vindo(a)!");
var pi = 3.14;
*/
if (typeof pi !== "undefined") {
	console.log(pi);
}

// ES 2015 (6% dos navegadores não suportam no mundo, pode-se usar tradutor Babel para tranformar esses JS antigos)
// caniuse.com - Para consultar qual navegador aceita a tecnologia.
var somarArrowFunction = (a, b) => a + b ;

somarArrowFunction(1, 2)
typeof somarArrowFunction()

var somar = function(a, b) {
	return a + b;
}

console.log("SomarSemRetorno", somarSemRetorno(1, 2));
typeof somarSemRetorno()

console.log("tem somar?", somar)
function somarSemRetorno(a, b, c = 3) {
	return a + b;
}

console.log("somar", somar(1, 2));
typeof somar 

console.log("somar(1, 2, 3)", somar(1, 2, 3));

