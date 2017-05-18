document.addEventListener('DOMContentLoaded', function() {
    let btnPesquisar = document.getElementById('btnPesquisar');

    btnPesquisar.onclick = function() { 
		let progress = document.getElementById('progress');
		let divProgress = document.createElement('div');

		divProgress.className += "progress-bar";
		divProgress.setAttribute('role', 'progressbar');
		divProgress.setAttribute('aria-valuenow', '60');
		divProgress.setAttribute('aria-valuemin', '0');
		divProgress.setAttribute('aria-valuemax', '100');		
		divProgress.setAttribute('style', 'width: 60%;')

		progress.append(divProgress);

		// divProgress.className += "progress-bar"
		
		// divProgress.setAttribute('role', 'progressbar');
		// divProgress.setAttribute('aria-valuenow', '60');
		// divProgress.setAttribute('aria-valuemin', '0');
		// divProgress.setAttribute('aria-valuemax', '100');
		// divProgress.setAttribute('style', 'width: 60%;')
	      
    }
})