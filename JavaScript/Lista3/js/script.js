document.addEventListener('DOMContentLoaded', function() {
    let btnPesquisar = document.getElementById('btnPesquisar');
    let numeroPkm = document.getElementById('numeroPkm');

    btnPesquisar.onclick = function() {    
      fetch(`http://pokeapi.co/api/v2/pokemon/${ numeroPkm.value }/`)
        .then(response => response.json())
        .then(json => {
          console.log(json);
          console.log(json.sprites.front_default);

          let div = document.getElementById('detalhesPokemon');
          let divImagem = document.getElementById('imagemPokemon');
          let name = document.createElement('h2');
          name.innerHTML = `Nome: ${ json.name }`;
          let numero = document.createElement('h2');
          numero.innerHTML = `Número: ${ json.id }`;
          let img = document.createElement('img');
          img.src = json.sprites.front_default;
          

          let types = document.createElement('ul');          
          json.types.forEach(a => {      
              let li = document.createElement('li');          
              li.innerHTML = a.type.name;
              types.append(li);
          });

          json.stats.forEach(a => { 
              let barras = document.getElementById('barras');   
              let span = document.createElement('span');             
              span.innerHTML = a.stat.name;
              let divProgress = loadProgressBar(a.base_stat);
              barras.append(span);
              barras.append(divProgress);
          });

          div.append(name);
          div.append(numero);
          div.append(types);            
          divImagem.append(img);        
    	})
    }

    function loadProgressBar(porcentagem) {
      let progress = document.createElement('div');
      progress.className += "progress";

      let div = document.createElement('div');
      div.className += "progress-bar progress-bar-striped";
      div.setAttribute('role', 'progressbar');
      div.setAttribute('aria-valuenow', `${ porcentagem }`);
      div.setAttribute('aria-valuemin', '0');
      div.setAttribute('aria-valuemax', '100');   
      div.setAttribute('style', `width: ${ porcentagem }%;`);

      // let span = document.createElement('span');
      // span = `${ porcentagem }%`;

      // div.append(span);
      progress.append(div);

      return progress;
}
})
