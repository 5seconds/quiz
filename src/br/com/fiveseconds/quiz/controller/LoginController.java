package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.LoginDao;
import br.com.fiveseconds.quiz.model.Usuario;
@Controller
public class LoginController {
	
	
	@RequestMapping("/ExibirLogin")
	public String ExibirLogin() {
		
	return "Login/login";
	}
		
	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model
	model) throws SQLException {
	
		LoginDao dao = new LoginDao();
	Usuario usuarioLogado = dao.buscarUsuario(usuario);
	
	if (usuarioLogado != null) {
	session.setAttribute("usuarioLogado", usuarioLogado);
	return "Login/HomeAdm";
	}
	dao.fecharConexao();
	model.addAttribute("msg", "Não foi encontrado um usuário com o login e senha informados.");
	return "Login/login";
	}

	@RequestMapping("logout")

		public String logout(HttpSession session) {
		
		session.invalidate();
		return "PaginaPrincipal/index";
	}
	
}
