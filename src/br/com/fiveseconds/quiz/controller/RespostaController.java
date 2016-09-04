package br.com.fiveseconds.quiz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;

@Controller
public class RespostaController {
	

	
    @RequestMapping("/ExibirJogo")
	public String ExibirJogo(Model model) {

		PerguntaDao dao = new PerguntaDao();
		List<Pergunta> listaPergunta = dao.listar();
		model.addAttribute("listaPergunta", listaPergunta);

		NivelDao dao2 = new NivelDao();
		List<Nivel> listaNivel = dao2.listar();
		model.addAttribute("listaNivel", listaNivel);

		DisciplinaDao dao3 = new DisciplinaDao();
		List<Disciplina> listaDiciplina = dao3.listar();
		model.addAttribute("listaDiciplina", listaDiciplina);

		return "Resposta/Resposta";
	}
    @RequestMapping("responder")
	public String responder(Model model, @RequestParam("idPergunta") int idPergunta,
			@RequestParam("idResposta") int idResposta) {

		AlternativaDao dao = new AlternativaDao();
		if (dao.verificaRespostaCorreta(idPergunta, idResposta)) {
			model.addAttribute("msg", "Alternativa Correta");
		} else {
			model.addAttribute("msg", "Alternativa incorreta");
		}
		
		model.addAttribute("idPergunta", idPergunta);
		model.addAttribute("idResposta", idResposta);

		return "forward:pesquisarPergunta";
	}
    @RequestMapping("/pesquisarPergunta")
	public String pesquisarPergunta(Pergunta pergunta, Model model) {

		// Código para popular o combo de categoria de produto

		NivelDao dao = new NivelDao();
		List<Nivel> listaNivel = dao.listar();
		model.addAttribute("listaNivel", listaNivel);

		DisciplinaDao dao2 = new DisciplinaDao();
		List<Disciplina> listaDiciplina = dao2.listar();
		model.addAttribute("listaDiciplina", listaDiciplina);

		PerguntaDao dao3 = new PerguntaDao();
		List<Pergunta> listaPergunta = dao3.pesquisar(pergunta);
		model.addAttribute("listaPergunta", listaPergunta);
		model.addAttribute("pergunta", pergunta);

		return "Resposta/Resposta";
	}

	

}
