package br.com.fiveseconds.quiz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;

@Controller
public class RespostaController {
	

	
	@RequestMapping("/ExibirJogo")
	public String ExibirJogo(Model model) {
		
		
		PerguntaDao dao = new PerguntaDao();
		List<Pergunta> listaPergunta = dao.listar();
		model.addAttribute("listaPergunta", listaPergunta);
		
		
	
		
		
	return "Resposta/Resposta";
	}
	
	@RequestMapping("responder")
	public String responder(Model model,@RequestParam("radio") int id) {
		
		AlternativaDao dao = new AlternativaDao();
		if(dao.ConsultarRespostaCorreta(id)){
			model.addAttribute("msg","Alternativa Correta");
		}else{
			model.addAttribute("msg","Alternativa incorreta");
		}
		
		
	
		
		
	return "Resposta/Resposta";
	}
	

	
	

}
