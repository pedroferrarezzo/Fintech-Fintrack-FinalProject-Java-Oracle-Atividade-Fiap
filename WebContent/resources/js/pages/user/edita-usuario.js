function updateRequiredStatus(element, others) {
	if (element.val().length > 0) {
		others.forEach(function(other) {
			other.attr('required', true);
		});
	} else {
		others.forEach(function(other) {
			other.removeAttr('required');
		});
	}
}

$(document).on("keyup change", "#tel", function() {
	
	updateRequiredStatus($(this), [$('#ddd'), $('#ddi')]);

	var textoInserido = $(this).val();

	// Substitua esta expressão regular pela que atenda às suas necessidades específicas
	var caracteresPermitidos = /^[^a-zA-Z\s]+$/;

	if (!caracteresPermitidos.test(textoInserido)) {
		// Remove caracteres inválidos (letras e espaços) do final do valor
		$(this).val(textoInserido.replace(/[^a-zA-Z\s]+$/, ''));
	}


});

$(document).on("keyup change", "#ddd", function() {
	updateRequiredStatus($(this), [$('#tel'), $('#ddi')]);
});

$(document).on("keyup change", "#ddi", function() {
	updateRequiredStatus($(this), [$('#tel'), $('#ddd')]);
});



$(document).on("keyup change", "#nm_pais", function() {
	updateRequiredStatus($(this), [$('#nm_estado'), $('#nm_cidade'), $('#nm_bairro'), $('#nm_rua')]);
});

$(document).on("keyup change", "#nm_estado", function() {
	updateRequiredStatus($(this), [$('#nm_pais'), $('#nm_cidade'), $('#nm_bairro'), $('#nm_rua')]);
});

$(document).on("keyup change", "#nm_cidade", function() {
	updateRequiredStatus($(this), [$('#nm_estado'), $('#nm_pais'), $('#nm_bairro'), $('#nm_rua')]);
});

$(document).on("keyup change", "#nm_bairro", function() {
	updateRequiredStatus($(this), [$('#nm_estado'), $('#nm_cidade'), $('#nm_pais'), $('#nm_rua')]);
});

$(document).on("keyup change", "#nm_rua", function() {
	updateRequiredStatus($(this), [$('#nm_estado'), $('#nm_cidade'), $('#nm_bairro'), $('#nm_pais')]);
});



