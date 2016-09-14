


	$(document).ready(function() {
		
		$("#nome").keyup(function() {
			var texto = $('#nome').val();
			var email = $('#email').val();
			$.post("PesquisarUsuario", {'nome' : texto, 'email' : email}, function(dados) {
				$('#tabelaListarUsuario').html(dados);
			});
		});

		$("#email").keyup(function() {
			var texto = $('#nome').val();
			var email = $('#email').val();
			$.post("PesquisarUsuario", {'nome' : texto, 'email' : email}, function(dados) {
				$('#tabelaListarUsuario').html(dados);
			});
		});
		
				
	});
	