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
	
	int limit = 0;

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

    @RequestMapping("/ExibirJogoADM")
    public String ExibirJogoADM(Model model) {

	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	return "Resposta/RespostaADM";
    }
    
    @RequestMapping("/proximoADM")
    public String proximoADM(Model model) {

	limit ++;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	return "Resposta/RespostaADM";
    }
    
    @RequestMapping("/anteriorADM")
    public String anteriorADM(Model model) {

	limit --;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	return "Resposta/RespostaADM";
    }
    
    @RequestMapping("/proximo")
    public String proximo(Model model) {

	limit ++;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	return "Resposta/Resposta";
    }
    
    @RequestMapping("/anterior")
    public String anterior(Model model) {

	limit --;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
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
    public String responder(Model model,
	    @RequestParam("idPergunta") int idPergunta,
	    @RequestParam("idResposta") int idResposta) {
//
//	AlternativaDao dao = new AlternativaDao();
//	if (dao.verificaRespostaCorreta(idPergunta, idResposta)) {
//	    model.addAttribute("msg", "Alternativa Correta");
//	} else {
//	    model.addAttribute("msg", "Alternativa incorreta");
//	}
//
//	model.addAttribute("idPergunta", idPergunta);
//	model.addAttribute("idResposta", idResposta);

	return "forward:pesquisarPergunta";
    }
    
    @RequestMapping("responderADM")
    public String responderADM(Model model,
	    @RequestParam("idPergunta") int idPergunta,
	    @RequestParam("idResposta") int idResposta) {
//
//	AlternativaDao dao = new AlternativaDao();
//	if (dao.verificaRespostaCorreta(idPergunta, idResposta)) {
//	    model.addAttribute("msg", "Alternativa Correta");
//	} else {
//	    model.addAttribute("msg", "Alternativa incorreta");
//	}
//
//	model.addAttribute("idPergunta", idPergunta);
//	model.addAttribute("idResposta", idResposta);

	return "forward:pesquisarPerguntaADM";
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

    @RequestMapping("/pesquisarPerguntaADM")
    public String pesquisarPerguntaADM(Pergunta pergunta, Model model) {

	// Código para popular o combo de categoria de produto

	limit ++;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	return "Resposta/RespostaADM";
    }

}
