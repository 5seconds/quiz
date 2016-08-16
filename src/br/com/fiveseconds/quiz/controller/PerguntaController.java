package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;

@Controller
public class PerguntaController {

	
	

	
		@RequestMapping("/ExibirCadastroPerguntas")
		public String ExibirCadastroPerguntas(Model model) {
			
			DisciplinaDao dao = new DisciplinaDao();
			List<Disciplina> listaDisciplina = dao.listar();
			model.addAttribute("listaDisciplina", listaDisciplina);
			
			NivelDao dao2 = new NivelDao();
			List<Nivel> listaNivel = dao2.listar();
			model.addAttribute("listaNivel", listaNivel);
			
			
		return "Perguntas/CadastrarPergunta";
		}
	
		@RequestMapping("CadastrarPerguntas")
		public String CadastrarPerguntas(Pergunta pergunta , Model model, HttpServletResponse response,HttpServletRequest request) throws SQLException {
			
			DisciplinaDao dao1 = new DisciplinaDao();
			List<Disciplina> listaDisciplina = dao1.listar();
			model.addAttribute("listaDisciplina", listaDisciplina);
			ArrayList<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
			
			
			for(int x=1;x<=4;x++){
			    Alternativas alternativa = new Alternativas();
				alternativa.setDescricao(request.getParameter("resposta"+x));
				if(request.getParameter("optionsRadios"+x) != null){
				    alternativa.setAlterCorreta("1");
				}else{
				    alternativa.setAlterCorreta("0");
				}
				
				listaAlternativa.add(alternativa);
			}
			
			pergunta.setAlternativas(listaAlternativa);
			
			NivelDao dao2 = new NivelDao();
			List<Nivel> listaNivel = dao2.listar();
			model.addAttribute("listaNivel", listaNivel);
			
			
			
		PerguntaDao dao = new PerguntaDao();
		dao.salvar(pergunta);
		dao.fecharConexao();
		model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
		return "Perguntas/CadastrarPergunta";
		}
}
