$(document).ready(function() {

		$("#descricao").keyup(function() {
			var texto = $('#descricao').val();
			$.post("AjaxPergunta", {
				'descricao' : texto,
			}, function(dados) {
				$('#tabelaListarPergunta').html(dados);
			});
		});
	});