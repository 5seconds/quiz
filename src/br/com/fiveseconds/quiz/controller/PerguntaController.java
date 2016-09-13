package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
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
    public String ExibirCadastroPerguntas(Model model) throws SQLException {

	DisciplinaDao dao = new DisciplinaDao();
	List<Disciplina> listaDisciplina = dao.listar();
	model.addAttribute("listaDisciplina", listaDisciplina);

	NivelDao dao2 = new NivelDao();
	List<Nivel> listaNivel = dao2.listar();
	model.addAttribute("listaNivel", listaNivel);
	dao.fecharConexao();
	dao2.fecharConexao();
	return "Perguntas/CadastrarPergunta";
    }

        @RequestMapping("CadastrarPerguntas")
    public String CadastrarPerguntas(Pergunta pergunta, Model model,
	    HttpServletResponse response, HttpServletRequest request)
	    throws SQLException {

	DisciplinaDao dao1 = new DisciplinaDao();
	List<Disciplina> listaDisciplina = dao1.listar();
	model.addAttribute("listaDisciplina", listaDisciplina);
	ArrayList<Alternativas> listaAlternativa = new ArrayList<Alternativas>();

	for (int x = 1; x <= 4; x++) {
	    String alte = request.getParameter("optionsRadios");
	    Alternativas alternativa = new Alternativas();

	    alternativa.setDescricao(request.getParameter("resposta" + x));

	    if (request.getParameter("optionsRadios").equals(String.valueOf(x))) {

		alternativa.setAlterCorreta("1");

	    } else {

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

	for (Alternativas alternativa : pergunta.getAlternativas()) {
	    daoAlter.salvar(alternativa, idPergunta);
	}
	
	daoAlter.fecharConexao();
	model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
	return "Perguntas/CadastrarPergunta";
    }

        
        
    @RequestMapping("/ExibirListarPerguntas")
    public String ExibirListarPerguntas(Model model,Pergunta pergunta) throws SQLException {

        	PerguntaDao dao = new PerguntaDao();
        	List<Pergunta> listarPergunta = dao.listar();
        	model.addAttribute("LISTAR", listarPergunta);
	 	dao.fecharConexao();
        	
		NivelDao dao2 = new NivelDao();
		List<Nivel> listaNivel = dao2.listar();
		model.addAttribute("listaNivel", listaNivel);
		dao2.fecharConexao();
		
		DisciplinaDao dao3 = new DisciplinaDao();
		List<Disciplina> listaDiciplina = dao3.listar();
		model.addAttribute("listaDiciplina", listaDiciplina);
		dao3.fecharConexao();
		
		PerguntaDao dao4 = new PerguntaDao();
		List<Pergunta> listaPergunta = dao4.pesquisar(pergunta);
		model.addAttribute("listaPergunta", listaPergunta);
		model.addAttribute("pergunta", pergunta);
		dao4.fecharConexao();
		
		
	return "Perguntas/ListarPerguntas";
    }
    
    /*
    @RequestMapping("/AjaxPergunta")
    public @ResponseBody String AjaxPergunta(@RequestParam String descricao, HttpServletResponse response) {

	PerguntaDao dao = new PerguntaDao();
	List<Pergunta> lista = dao.AjaxPergunta(descricao);

	StringBuilder st = new StringBuilder();
	st.append("<center>");
	st.append("<table id='tabelaListarPergunta'class='table' style='background-color:black ;'>");
	st.append("<thead>");
	st.append("<tr>");
	st.append("<th style='width: 3%; vertical-align: middle; text-align: center; font-size: 20px';> ID </th>");
	st.append("<th style='width: 50%; vertical-align: middle; text-align: center; font-size: 20px';> PERGUNTA  </th>");
	st.append("<th style='width: 5%; vertical-align: middle; text-align: center; font-size: 20px';> NÍVEL  </th>");
	st.append("<th style='width: 8%; vertical-align: middle; text-align: center; font-size: 20px';> DISCIPLINA  </th>");
	st.append("<th style='width: 5%; vertical-align: middle; text-align: center; font-size: 20px';> AÇÕES  </th>");
	st.append("</tr>");
	st.append("<thead>");

	for (Pergunta p : lista) {
	    st.append("<tr>");
	    st.append("<td style='width: 3%; vertical-align: middle; text-align: center; font-size: 15px;'> " + p.getId() + " </td>");
	    st.append("<td style='width: 50%; vertical-align: middle; text-align: center; font-size: 20px;'> " + p.getDescricao() + " </td>");
	    st.append("<td style='width: 5%; vertical-align: middle; text-align: center; font-size: 15px;color: yellow;'> " + p.getNivel().getNome() + " </td>");
	    st.append("<td style='width: 8%; vertical-align: middle; text-align: center; font-size: 15px;color: pink;'> " + p.getDisciplina().getNome() + " </td>");
	    st.append("<td style='width: 5%; vertical-align: middle; text-align: center; font-size: 15px;'>");
	    st.append("<a href='PerguntabuscarPorId?id=" + p.getId()   + "'class='btn btn-warning' role='button'> E </a>&nbsp;");
	    st.append("<a href='removerPergunta?id=" + p.getId()   + "'	class='btn btn-danger' role='button'> R </a>");
	    st.append("</td>");
	    st.append("</tr>");

	}
	st.append("</table>");
	st.append("</center>");

	response.setStatus(200);
	return st.toString();

    }
*/
    @RequestMapping("removerPergunta")
    public String removerPergunta(Pergunta pergunta, Model model) throws SQLException {

	PerguntaDao dao = new PerguntaDao();
	dao.remover(pergunta);
	model.addAttribute("msg", "Pergunta Removida");
	dao.fecharConexao();
	return "forward:ExibirListarPerguntas";
    }
    
    @RequestMapping("PerguntabuscarPorId")
	public String buscarPorId(Model model, Pergunta pergunta) throws SQLException {

		DisciplinaDao dao1 = new DisciplinaDao();
		List<Disciplina> listaDisciplina = dao1.listar();
		model.addAttribute("listaDisciplina", listaDisciplina);
		dao1.fecharConexao();
		
		NivelDao dao2 = new NivelDao();
		List<Nivel> listaNivel = dao2.listar();
		model.addAttribute("listaNivel", listaNivel);
		dao2.fecharConexao();
		
		PerguntaDao dao = new PerguntaDao();
		pergunta = dao.buscarPorId(pergunta.getId());
		model.addAttribute("pergunta", pergunta);
		dao.fecharConexao();
		
		for (int x = 0, c = 0, t = 1; c <= t; x++) {
			AlternativaDao dao3 = new AlternativaDao();
			Alternativas resposta1 = dao3.buscarPorId(x, pergunta);
			if (resposta1 != null) {
				c++;
				if (c == t) {
					model.addAttribute("resposta" + c + "", resposta1);
					t++;
					dao3.fecharConexao();

					if (t == 5) {
						break;
					}
				}
			}
			dao3.fecharConexao();
		}

		
		return "Perguntas/AlterarPerguntas";
	}
    
    @RequestMapping("PerguntaAlterar")
	public String alterar(Pergunta pergunta, Model model, HttpServletResponse response, HttpServletRequest request)
			throws SQLException {

		DisciplinaDao dao1 = new DisciplinaDao();
		List<Disciplina> listaDisciplina = dao1.listar();
		model.addAttribute("listaDisciplina", listaDisciplina);
		ArrayList<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
		dao1.fecharConexao();

		for (int x = 1; x <= 4; x++) {
			String alte = request.getParameter("optionsRadios");
			Alternativas alternativa = new Alternativas();

			alternativa.setDescricao(request.getParameter("resposta" + x));

			if (request.getParameter("optionsRadios").equals(String.valueOf(x))) {

				alternativa.setAlterCorreta("1");

			} else {

				alternativa.setAlterCorreta("0");
			}

			listaAlternativa.add(alternativa);
		}

		pergunta.setAlternativas(listaAlternativa);

		NivelDao dao2 = new NivelDao();
		List<Nivel> listaNivel = dao2.listar();
		model.addAttribute("listaNivel", listaNivel);
		dao2.fecharConexao();
		
		PerguntaDao dao = new PerguntaDao();
		dao.alterar(pergunta);

		model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
		int idPergunta = dao.buscarUltimoId();
		dao.fecharConexao();

		pergunta.setId(idPergunta);
		AlternativaDao daoAlter = new AlternativaDao();

		Alternativas alternativas = daoAlter.buscarPorIdAlternativa(pergunta.getId());

		int x = alternativas.getId();

		for (Alternativas alternativa : pergunta.getAlternativas()) {

			daoAlter.alterar(alternativa, idPergunta, x);
			x++;

		}

		daoAlter.fecharConexao();
		model.addAttribute("mensagem", "Pergunta Cadastrada com sucesso!");
		return "forward:ExibirListarPerguntas";

		
	}

/*
    @RequestMapping("/ListarDisciplinaNivel")
    public String ListarDisciplinaNivel(Model model) {

	DisciplinaDao dao = new DisciplinaDao();
	List<Disciplina> Disciplina = dao.listar();
	model.addAttribute("Disciplina", Disciplina);

	NivelDao dao2 = new NivelDao();
	List<Nivel> Nivel = dao2.listar();
	model.addAttribute("Nivel", Nivel);

	return "Perguntas/ListarPerguntas";
    }
*/
    /*
     * @RequestMapping("alterarPergunta") public String alterarPergunta(Pergunta
     * pergunta, Model model) {
     * 
     * PerguntaDao dao = new PerguntaDao(); dao.alterar(pergunta);
     * model.addAttribute("msg", "Pergunta alterada com sucesso !");
     * 
     * return "forward:ExibirListarPerguntas"; }
     * 
     * @RequestMapping("exibirAlterarPergunta") public String
     * exibirAlterarPergunta(Pergunta pergunta, Model model) {
     * 
     * PerguntaDao dao = new PerguntaDao(); Pergunta perguntaPreenchido =
     * dao.buscarPorId(pergunta.getId()); model.addAttribute("pergunta",
     * perguntaPreenchido);
     * 
     * return "Perguntas/AlterarPergunta"; }
     */
    
    
}
