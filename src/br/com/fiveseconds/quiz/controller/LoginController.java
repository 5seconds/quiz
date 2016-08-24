package br.com.fiveseconds.quiz.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.LoginDao;
import br.com.fiveseconds.quiz.model.Usuario;
import br.com.fiveseconds.quiz.util.Criptografia;
@Controller
public class LoginController {


	@RequestMapping("/ExibirLogin")
	public String ExibirLogin() {

		return "Login/login";
	}


	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model
			model) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {


		LoginDao dao = new LoginDao();
		usuario.setSenha(Criptografia.sha1(usuario.getSenha()));
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		dao.fecharConexao();

		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);

			if(usuarioLogado.getTipoUsuario().getId() == 2){
				return "Login/HomeAdm";
			}
			else{
				return "Login/Home";
			}

		}else{
			model.addAttribute("msg", "Não foi encontrado um usuário com o login e senha informados.");
			return "Login/login";
		}

	}

	@RequestMapping("logout")

	public String logout(HttpSession session) {

		session.invalidate();
		return "Login/login";
	}

}
