$(document).ready(function() {

		$("#nivel").keyup(function() {
			var nivel = $('#nivel').val();
			var disciplina = $('#disciplina').val();

			$('#idNivel').val(nivel);
			$('#idDisciplina').val(disciplina);
		});

		$("#disciplina").change(function() {
			var nivel = $('#nivel').val();
			var disciplina = $('#disciplina').val();

			$('#idNivel').val(nivel);
			$('#idDisciplina').val(disciplina);
		});
	});

	function marcarResposta(idPergunta, idResposta) {

		document.getElementById("idPergunta").value = idPergunta;
		document.getElementById("idResposta").value = idResposta;
	}

	$(document).ready(function() {

		$("#div1").prop('disabled', false);

		$("#btn").click(function() {
			
			$.ajax({url : "view/Resposta/verificarResposta.jsp",data : {
				
					radioResposta : $('input:radio[name=radioResposta]:checked').val()
																		},
				success : function(result) {
	
					$("#div1").html(result);
						document.getElementById("div1").style.display = "";
						
				}
			});
		});
						
						
						
		$('#form').validate({

			rules : {
					radioResposta : {
					required : true,
					
				}

			},
			messages : {
				
					radioResposta : {
					required : "Selecione qual a resposta CORRETA",
					
				}
			}

		});
	});