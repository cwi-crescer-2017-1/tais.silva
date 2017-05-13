// Exercício 1: séries inválidas.
function seriesInvalidas(series) {  
  var titulosInvalidos = [];
  series
  // .filter(a => a.anoEstreia);
  .forEach(a => { if(a.anoEstreia > new Date().getFullYear()) titulosInvalidos.push(a.titulo) });  
  return "Séries Inválidas: " + titulosInvalidos.join(" - ");
}

console.log(seriesInvalidas(series)); 

// Exercício 2: séries a partir de um determinado ano.
/*Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.*/
filtrarSeriesPorAno(series, ano) {

}

filtrarSeriesPorAno(series, 2017); // retorna um array com todas as séries com ano de estreia igual ou maior que 2017.

Exercício 3

Média de Episódios

Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.

Exemplo:

mediaDeEpisodios(series); // retorna o valor da média da soma dos episódios/quantidade de séries no array.
Exercício 4

Eu sou um ator de séries?

Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.

Exemplo:

procurarPorNome(series, "Mateus"); // retorna verdadeiro se tiver um "Mateus" em algum dos elencos
Dica: No campo nome da função experimente passar seu próprio nome.