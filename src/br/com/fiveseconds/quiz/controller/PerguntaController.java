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
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.dao.UsuarioDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.Usuario;

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
	
		
		@RequestMapping("/ExibirListarPerguntas")
		public String ExibirListarPerguntas(Model model) {

			return "Perguntas/ListarPerguntas";
		}
		
		@RequestMapping("CadastrarPerguntas")
		public String CadastrarPerguntas(Pergunta pergunta , Model model, HttpServletResponse response,HttpServletRequest request) throws SQLException {
			
			DisciplinaDao dao1 = new DisciplinaDao();
			List<Disciplina> listaDisciplina = dao1.listar();
			model.addAttribute("listaDisciplina", listaDisciplina);
			ArrayList<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
			
			
			for(int x=1;x<=4;x++){
			   String alte = request.getParameter("optionsRadios");
			    Alternativas alternativa = new Alternativas();
				
			    alternativa.setDescricao(request.getParameter("resposta"+x));
				
				if(request.getParameter("optionsRadios").equals(String.valueOf(x))) {
				    
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
		
		int idPergunta = dao.buscarUltimoId();
		dao.fecharConexao();
		
		pergunta.setId(idPergunta);
		AlternativaDao daoAlter = new AlternativaDao();
		
		for(Alternativas alternativa : pergunta.getAlternativas()){
		    daoAlter.salvar(alternativa,idPergunta);
		}
		
		daoAlter.fecharConexao();
		model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
		return "Perguntas/CadastrarPergunta";
		}
		
		
		
		
		@RequestMapping("/PesquisarPergunta")
		public @ResponseBody String pesquisarPergunta(@RequestParam String pergunta, HttpServletResponse response) {

			PerguntaDao dao = new PerguntaDao();
			List<Pergunta> listarPergunta = dao.pesquisar(pergunta);

			StringBuilder st = new StringBuilder();
			st.append("<center>");
			st.append("<table border='1' style='width: 80%; text-align: center'>");
			st.append("<thead>");
			st.append("<tr>");
			st.append("<th> ID </th>");
			st.append("<th> PERGUNTA  </th>");
			st.append("<th> NÍVEL  </th>");
			st.append("<th> DISCIPLINA  </th>");
			st.append("<th> AÇÔES  </th>");
			st.append("</tr>");
			st.append("<thead>");
			
			for (Pergunta p : listarPergunta) {
				st.append("<tr>");
				st.append("<td> " + p.getId() + " </td>");
				st.append("<td> " + p.getDescricao() + " </td>");
				st.append("<td> " + p.getNivel() + " </td>");
				st.append("<td> " + p.getDisciplina()+ " </td>");
				st.append("<td>");
				st.append("<a href='exibirAlterarPergunta?id="+ p.getId() +"' class='btn btn-info' role='button' > Alterar </a> &nbsp;");
				st.append("<a href='removerPergunta?id=" + p.getId() + "' class='btn btn-danger' role='button'> Remover </a>");
				st.append("</td>");
				st.append("</tr>");
				
			}
			st.append("</table>");
			st.append("</center>");
			
			
			response.setStatus(200);
			return st.toString();

		}
		
		
		@RequestMapping("removerPergunta")
		public String removerPergunta(Pergunta pergunta, Model model) {

			PerguntaDao dao = new PerguntaDao();
			dao.remover(pergunta);
			model.addAttribute("msg", "Pergunta Deletada");

			return "forward:ExibirListarPergunta";
		}
/*
		@RequestMapping("alterarPergunta")
		public String alterarUsuario(Pergunta pergunta, Model model) {

			PerguntaDao dao = new PerguntaDao();
			dao.alterar(pergunta);
			model.addAttribute("msg", "Pergunta alterada com sucesso !");

			return "forward:ExibirListarPergunta";
		}
*/
		@RequestMapping("exibirAlterarPergunta")
		public String exibirAlterarUsuario(Pergunta pergunta, Model model) {

			PerguntaDao dao = new PerguntaDao();
			Pergunta perguntaPreenchido = dao.buscarPorId(pergunta.getId());
			model.addAttribute("pergunta", perguntaPreenchido);

			return "Pergunta/AlterarPergunta";
		}

}
