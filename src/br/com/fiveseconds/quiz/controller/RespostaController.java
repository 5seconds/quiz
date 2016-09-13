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
    public Nivel nivel= null;
    public Disciplina disicplina= null;

    // CLIENTE

    @RequestMapping("/ExibirJogo")
    public String ExibirJogo(Model model) throws SQLException {

    limit = 0;
	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao.fecharConexao();

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao2.fecharConexao();
	
	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao3.fecharConexao();
	
	return "Resposta/Resposta";
    }

    // ADMINISTRADOR

    @RequestMapping("/ExibirJogoADM")
    public String ExibirJogoADM(Model model) throws SQLException {

	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> listaPergunta = dao.listarPerguntaUnica(limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao.fecharConexao();
	
	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao2.fecharConexao();
	
	DisciplinaDao dao3 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao3.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao3.fecharConexao();
	
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
	
	limit=0;
	this.disicplina = pergunta.getDisciplina();
	this.nivel = pergunta.getNivel();
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();

	return "Resposta/Resposta";
    }
    
   

    // ADMINISTRADOR

    @RequestMapping("/pesquisarPerguntaADM")
    public String pesquisarPerguntaADM(Pergunta pergunta, Model model) throws SQLException {

	limit=0;
	this.disicplina = pergunta.getDisciplina();
	this.nivel = pergunta.getNivel();
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit++;
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	
	return "Resposta/RespostaADM";
    }

    // CLIENTE

    @RequestMapping("/proximo")
    public String proximo(Model model, Pergunta pergunta) throws SQLException {

	pergunta.setDisciplina(this.disicplina);
	pergunta.setNivel(this.nivel);
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit++;
	if(limit > 4 ){
	   
	    return "forward:pesquisarPerguntaADM";
	}
	else{
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	}

	return "Resposta/Resposta";
    }

    // ADMINISTRADOR

    @RequestMapping("/proximoADM")
    public String proximoADM(Model model, Pergunta pergunta) throws SQLException {


	pergunta.setDisciplina(this.disicplina);
	pergunta.setNivel(this.nivel);
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit++;
	if(limit > 4){
	   
	    return "forward:pesquisarPerguntaADM";
	}
	else{
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	}
	return "Resposta/RespostaADM";
    }

    // CLIENTE
    @RequestMapping("/anterior")
    public String anterior(Model model, Pergunta pergunta) throws SQLException {
	
	pergunta.setDisciplina(this.disicplina);
	pergunta.setNivel(this.nivel);
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit--;
	if(limit < 0 ){
	   
	    return "forward:pesquisarPergunta";
	}
	else{
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	}
	
	return "Resposta/Resposta";
    }

    // ADMINISTRADOR

    @RequestMapping("/anteriorADM")
    public String anteriorADM(Model model, Pergunta pergunta) throws SQLException {

	pergunta.setDisciplina(this.disicplina);
	pergunta.setNivel(this.nivel);
	
	NivelDao dao = new NivelDao();
	List<Nivel> listaNivel = dao.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	
	DisciplinaDao dao2 = new DisciplinaDao();
	List<Disciplina> listaDiciplina = dao2.listar();
	model.addAttribute("listaDiciplina", listaDiciplina);
	dao2.fecharConexao();
	
	limit--;
	if(limit < 0 ){
	   
	    return "forward:pesquisarPergunta";
	}
	else{
	PerguntaDao dao3 = new PerguntaDao();
	List<Pergunta> listaPergunta = dao3.pesquisarLimit(pergunta, limit);
	model.addAttribute("listaPergunta", listaPergunta);
	dao3.fecharConexao();
	}

	return "Resposta/RespostaADM";
    }

}
