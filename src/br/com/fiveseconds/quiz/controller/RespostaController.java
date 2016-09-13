package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;

@Controller
public class RespostaController {

    public int limit = 0;

    // CLIENTE

    @RequestMapping("/ExibirJogo")
    public String ExibirJogo(Model model) {

    limit = 0;
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

    // ADMINISTRADOR

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

    // CLIENTE

    @RequestMapping("responder")
    public String responder(Model model,
	    @RequestParam("idPergunta") int idPergunta,
	    @RequestParam("idResposta") int idResposta) {
	//
	// AlternativaDao dao = new AlternativaDao();
	// if (dao.verificaRespostaCorreta(idPergunta, idResposta)) {
	// model.addAttribute("msg", "Alternativa Correta");
	// } else {
	// model.addAttribute("msg", "Alternativa incorreta");
	// }
	//
	// model.addAttribute("idPergunta", idPergunta);
	// model.addAttribute("idResposta", idResposta);

	return "forward:pesquisarPergunta";
    }

    // ADMINISTRADOR

    @RequestMapping("responderADM")
    public String responderADM(Model model,
	    @RequestParam("idPergunta") int idPergunta,
	    @RequestParam("idResposta") int idResposta) {
	//
	// AlternativaDao dao = new AlternativaDao();
	// if (dao.verificaRespostaCorreta(idPergunta, idResposta)) {
	// model.addAttribute("msg", "Alternativa Correta");
	// } else {
	// model.addAttribute("msg", "Alternativa incorreta");
	// }
	//
	// model.addAttribute("idPergunta", idPergunta);
	// model.addAttribute("idResposta", idResposta);

	return "forward:pesquisarPerguntaADM";
    }

    // CLIENTE

    @RequestMapping("/pesquisarPergunta")
    public String pesquisarPergunta(Pergunta pergunta, Model model) throws SQLException {


	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();

	return "Resposta/Resposta";
    }
    
   

    // ADMINISTRADOR

    @RequestMapping("/pesquisarPerguntaADM")
    public String pesquisarPerguntaADM(Pergunta pergunta, Model model) {

	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);

	return "Resposta/RespostaADM";
    }

    // CLIENTE

    @RequestMapping("/proximo")
    public String proximo(Model model, Pergunta pergunta) throws SQLException {

		
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();

	return "Resposta/Resposta";
    }

    // ADMINISTRADOR

    @RequestMapping("/proximoADM")
    public String proximoADM(Model model, Pergunta pergunta) throws SQLException {

	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();

	return "Resposta/RespostaADM";
    }

    // CLIENTE
    @RequestMapping("/anterior")
    public String anterior(Model model, Pergunta pergunta) throws SQLException {
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit--;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	return "Resposta/Resposta";
    }

    // ADMINISTRADOR

    @RequestMapping("/anteriorADM")
    public String anteriorADM(Model model, Pergunta pergunta) throws SQLException {

	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);

	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);

	limit--;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();

	return "Resposta/RespostaADM";
    }

}
