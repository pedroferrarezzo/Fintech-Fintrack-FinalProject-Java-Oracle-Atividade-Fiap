/* globals Chart:false, feather:false */

(function() {
	'use strict'

	feather.replace({ 'aria-hidden': 'true' })

	// Graphs
	var ctx = document.getElementById('myChart')
	// eslint-disable-next-line no-unused-vars

	let saldo_janeiro = document.getElementById('janeiro').value;
	let saldo_fevereiro = document.getElementById('fevereiro').value;
	let saldo_marco = document.getElementById('marco').value;
	let saldo_abril = document.getElementById('abril').value;
	let saldo_maio = document.getElementById('maio').value;
	let saldo_junho = document.getElementById('junho').value;
	let saldo_julho = document.getElementById('julho').value;
	let saldo_agosto = document.getElementById('agosto').value;
	let saldo_setembro = document.getElementById('setembro').value;
	let saldo_outubro = document.getElementById('outubro').value;
	let saldo_novembro = document.getElementById('novembro').value;
	let saldo_dezembro = document.getElementById('dezembro').value;


	var myChart = new Chart(ctx, {
		type: 'line',
		data: {
			labels: [
				'Janeiro',
				'Fevereiro',
				'Março',
				'Abril',
				'Maio',
				'Junho',
				'Julho',
				'Agosto',
				'Setembro',
				'Outubro',
				'Novembro',
				'Dezembro'
			],
			datasets: [{
				data: [
					saldo_janeiro,
					saldo_fevereiro,
					saldo_marco,
					saldo_abril,
					saldo_maio,
					saldo_junho,
					saldo_julho,
					saldo_agosto,
					saldo_setembro,
					saldo_outubro,
					saldo_novembro,
					saldo_dezembro
				],

				lineTension: 0,
				backgroundColor: 'transparent',
				borderColor: '#6610f2',
				borderWidth: 4,
				pointBackgroundColor: '#6610f2'
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: false
					}
				}]
			},
			legend: {
				display: false
			}
		}
	})
})()


function imprimir() {
        window.print();
}

document.addEventListener("DOMContentLoaded", function () {
    var hiddenSection = document.querySelector('.hidden');

    // Adiciona um ouvinte de evento de mouseover
    document.addEventListener("mouseover", function () {
        // Remove a classe 'hidden' para exibir o conteúdo
        hiddenSection.classList.remove('hidden');
    });
});


