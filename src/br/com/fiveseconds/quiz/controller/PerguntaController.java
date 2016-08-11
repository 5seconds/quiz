package br.com.fiveseconds.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PerguntaController {

	
	
	//Feito!
		@RequestMapping("/ExibirCadastroPerguntas")
		public String ExibirCadastroPerguntas() {
			
		return "Perguntas/CadastrarPergunta";
		}
}
