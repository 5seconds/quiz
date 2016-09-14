	$(document).ready(function() {
		$('#meuForm').validate({

			rules : {
				descricao : {
					required : true,
					minlength : 10

				},
				disciplina : {
					required : true
					
				},
				nivel : {
					required : true
					

				},
				resposta1 : {
					required : true,
					

				},
				resposta2 : {
					required : true,
					

				},
				resposta3 : {
					required : true,
					
					

				},
				resposta4 : {
					required : true,
					
					

				},
				optionsRadios : {
					required : true,
					
				}

			},
			messages : {
				descricao : {
					required : "Este campo é obrigatório",
					minlength : "A Pergunta deve conter no minimo 10 caracteres"

				},
				disciplina : {
					required : "Este campo é obrigatório",
					
				},
				nivel : {
					required : "Este campo é obrigatório",
					

				},
				resposta1 : {
					required : "Este campo é obrigatório",
					
				},
				resposta2 : {
					required : "Este campo é obrigatório",
					
				},
				resposta3 : {
					required : "Este campo é obrigatório",
					
					
				},
				resposta4 : {
					required : "Este campo é obrigatório",
					
				},

				optionsRadios : {
					required : "Selecione qual a resposta CORRETA",
					
				}
			}

		});
	});