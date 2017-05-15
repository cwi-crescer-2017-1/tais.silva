if(!String.prototype.temAbreviacao) {
	String.prototype.temAbreviacao = function() {
		return this.match(/ [A-Z][.] /gi) !== null;
}
}

if(!String.prototype.pegarUltimoNome) {
	String.prototype.pegarUltimoNome = function(a, b) {
		let partesNome = this.trim().split(" ");
		return partesNome[partesNome.length - 1];
	}
}
