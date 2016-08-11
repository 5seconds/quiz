package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.TipoUsuario;

@Controller
public class PerguntaController {

	
	
	//Feito!
		@RequestMapping("/ExibirCadastroPerguntas")
		public String ExibirCadastroPerguntas() {
			
		return "Perguntas/CadastrarPergunta";
		}
	
		//Feito!
		@RequestMapping("CadastrarPerguntas")
		public String CadastrarPerguntas(@Valid Pergunta pergunta , Model model) throws SQLException {
			
			
		PerguntaDao dao = new PerguntaDao();
		
		
		dao.salvar(pergunta);
		dao.fecharConexao();
		model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
		return "Perguntas/CadastrarPergunta";
		}
}
