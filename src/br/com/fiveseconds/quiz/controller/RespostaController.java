package br.com.fiveseconds.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RespostaController {
	

	
	@RequestMapping("/ExibirJogo")
	public String ExibirJogo() {
		
	return "Resposta/Resposta";
	}

}
