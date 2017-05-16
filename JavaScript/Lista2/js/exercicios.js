// Exercício 1: séries inválidas.
function seriesInvalidas(series) {  
	/*var titulosInvalidos = series
							.filter(a => a.anoEstreia > new Date().getFullYear());	
	series
	.forEach(a => {
		var atributos = Object.keys(a);
		atributos
			.forEach(b => {if (a[b] === null || typeof a[b] === "undefined" ) titulosInvalidos.push(a)})})
	return "Séries Inválidas: " + titulosInvalidos.map(a => a.titulo).join(" - ");*/
	let invalidas = series.filter(serie => {
	    // for (let campo in serie) { }
	    let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
	    let estreiaInvalida = serie.anoEstreia > new Date().getFullYear();
	    return estreiaInvalida || algumCampoInvalido;
	});
	return `Séries Inválidas: ${ invalidas.map(s => s.titulo).join(" - ") }`;
}

console.log(`Exercício 1: ${seriesInvalidas(series)}`); 

// Exercício 2: séries a partir de um determinado ano.
/*Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.*/
function filtrarSeriesPorAno(series, ano) {
	return series
			.filter(a => a.anoEstreia >= ano);
}

console.log(`Exercício 2: ${filtrarSeriesPorAno(series, 2017)}`); // retorna um array com todas as séries com ano de estreia igual ou maior que 2017.

// Exercício 3: média de Episódios.
// Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séries e retorna a média dos episódios de todas as séries contidas no array. 
function mediaDeEpisodios(series) {
		// var resultado = 0;

		// series
		// .forEach(a => {
		// 	resultado += a.numeroEpisodios 
		// })

		// var mediaEpisodios = resultado / series.length;

		return series
				.map(a => a.numeroEpisodios)
				.reduce((a,b) => a + b) / series.length;
}

console.log(`Exercício 3: Média de episódios por série: ${mediaDeEpisodios(series)}`); // retorna o valor da média da soma dos episódios/quantidade de séries no array.

// Exercício 4: eu sou um ator de séries?
// Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.
function procurarPorNome(series, nome) {
	var resposta = false;

	series
	.forEach(a => {
		a.elenco.forEach(b => {
			if(b.includes(nome))
				resposta = true
		})
	});

	return resposta;
	// // indexOf
	// return series.some(s => s.elenco.some(e => e.includes(nome)));
}

console.log(`Exercício 4: tem o nome? ${procurarPorNome(series, "Tais")}`); // retorna verdadeiro se tiver um "Mateus" em algum dos elencos. Dica: No campo nome da função experimente passar seu próprio nome.

// Exercício 5: mascada em série
// Uma série tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada série. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;
function mascadaEmSerie(serie) {
	return (serie.diretor.length * 100000) + (serie.elenco.length * 40000);	 
}

console.log(`Exercício 5: total mascada $${mascadaEmSerie(series[0])}`); //Retorna o valor total de gastos contando os diretores e o elenco

// Exercício 6: buscas!
// A) Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que retorne um array, com os títulos das séries que são correspondentes com o genero do parâmetro.
function queroGenero(genero) {
	/*var arrayGenero = [];
	series
	.forEach(a => 
		a.genero
		.forEach( b => {
			if (genero === b)
				arrayGenero.push(a.titulo)
		})
	); 

	return arrayGenero;*/

	return series.filter(s => s.genero.includes(genero));
}

console.log("Exercício 6a: os filmes desse gênero são", queroGenero("Caos")); // Retorna ["Bernardo The Master of the Wizards", "10 Days Why"]

// B) Sei exatamente o que quero assisitir! Escreva uma função chamada queroTitulo que retorne um array, com os títulos das séries que tem título semelhante ao passado
function queroTitulo(parteTitulo) {
	var arrayFilmes = [];

	series
	.forEach(a => {
		if (a.titulo.includes(parteTitulo))
			arrayFilmes.push(a.titulo)
	}); 
	
	return arrayFilmes;
	/*return series
		    .filter(s => s.titulo.includes(titulo))
		    .map(s => s.titulo);
	
	let subset = queroTitulo("The");
	let divSubset = document.getElementById('subset');
	subset.forEach(titulo => {
		let h2 = document.createElement('h2');
		h2.innerText = `${ titulo }`;
		divSubset.append(h2);
	}*/
}

console.log("Exercício 6b: filmes com essa busca", queroTitulo("The")); // Retorna ["The Walking Dead", "Bernardo The Master of the Wizards"]

// Exercício 7: créditos
// Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função, chamada de creditosIlluminatis que recebe uma série como parâmetro e imprima os créditos a partir dela. Deverá ser impresso, o Título da serie, os Diretores, avisando com um título que é o bloco deles. Em seguida vem o elenco, também com um título de Elenco. Os créditos são sempre ordenados alfabeticamente, mas pelo ÚLTIMO NOME!! 
function creditosIlluminatis(n) {
	const titulo = n.titulo + "\n";	

	const diretor = n.diretor
					.map(a => a.replace(/(\w+)\s(\w+)/, '$2, $1'))
					.sort()
					.join("\n");

	const elenco = n.elenco
					.map(a => a.replace(/(\w+)\s(\w+)/, '$2, $1'))
					.sort()
					.join("\n");

	return titulo + "Direção: \n" + diretor + "\n" + "Elenco: \n" + elenco;
	/*let criterioDeOrdenacao = (s1, s2) => {
    return s1.pegarUltimoNome().localeCompare(s2.pegarUltimoNome())
	}
	let elencoOrdenado = serie.elenco.sort(criterioDeOrdenacao);
	let diretoresOrdenados = serie.diretor.sort(criterioDeOrdenacao);

	console.log(serie.titulo);
	console.log("Diretores");
	console.log(diretoresOrdenados);
	console.log("Elenco");
	console.log(elencoOrdenado);*/
}

console.log("Exercício 7: créditos do episódio.\n" + creditosIlluminatis(series[0]));

// Exercício 8: serie illuminati
function sobrenomeAbreviado(series) {
	var serie = "Nenhuma";
	var elenco;

	function testarAbreviacao(arrayString) {
		var serieAbreviada = true;

		arrayString
		.forEach(a => {
			if(a[(a.indexOf(" ") + 2)] !== ".")
				return serieAbreviada = false;
		}) 
		 
		return serieAbreviada;
	}

	series
	.forEach(a => { 
		if(testarAbreviacao(a.elenco)) {
			serie = a.titulo
			elenco = a.elenco;
		}
	});

	var hashtag = "#"+ elenco
						.map(a => a[a.indexOf(" ") + 1])
						.reduce((a,b) => a + b);

	return `\nNome da série: ${serie}\nHashtag: ${hashtag}`;
}

console.log("Exercício 8: " + sobrenomeAbreviado(series));

// 8 do Bernardo
function descobrirSerieComTodosAbreviados() {
  let elencoSerie = series
    .find(s => s.elenco.every(e => e.temAbreviacao()))
    .elenco
    .map(e => e.match(/ [a-z][.] /gi)[0][1])
    .join("");
  return `#${ elencoSerie }`;
}

console.log("Do Bernardo: " + descobrirSerieComTodosAbreviados());

// Exercício de arredondamento
function parametrizarDecimal(num, dec) {
	dec = dec || 2;
	/*if(typeof dec === "undefined") {
		dec = 2;
	}*/
	var round = Math.round(num).toString().length;
	return  Number(Math.round(num).toString() + "." + num.toString().replace(/[\.-]/g, "").substr(round, dec));
}

console.log(parametrizarDecimal(10.235, 3));