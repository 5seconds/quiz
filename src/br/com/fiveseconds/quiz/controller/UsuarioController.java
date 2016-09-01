package br.com.fiveseconds.quiz.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.UsuarioDao;

import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;
import br.com.fiveseconds.quiz.util.Criptografia;

@Controller
public class UsuarioController {

	
	@RequestMapping("/ExibirIndex")
	public String ExibirIndex() {

		return "PaginaPrincipal/index";
	}

	
	@RequestMapping("/ExibirCadastrarUsuario")
	public String ExibirCadastrarUsuario(Model model) {

		return "Usuario/CadastroUsuario";
	}
	
	@RequestMapping("/ExibirHome")
	public String ExibirHome() {

		return "Login/Home";
	}
	
	@RequestMapping("/ExibirHomeAdm")
	public String ExibirHomeAdm() {

		return "Login/HomeAdm";
	}

	
	@RequestMapping("CadastrarUsuario")
	public String CadastrarUsuario(@Valid Usuario usuario, Model model)
			throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {

		UsuarioDao dao = new UsuarioDao();
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(1);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setSenha(Criptografia.sha1(usuario.getSenha()));

		dao.salvar(usuario);
		dao.fecharConexao();
		model.addAttribute("mensagem", "Cadastro Realizado com Sucesso");
		return "Usuario/CadastroUsuario";
	}

	@RequestMapping("/ExibirListarUsuario")
	public String ExibirListarUsuario(Model model) {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listarUsuario = dao.listar();
		model.addAttribute("listarUsuario", listarUsuario);

		
		
		return "Usuario/ListarUsuario";
	}



	@RequestMapping("/PesquisarUsuario")
	public String pesquisarUsuario(Usuario usuario, Model model) {
		
	UsuarioDao dao = new UsuarioDao();
	List<Usuario> listarUsuariodao = dao.listar();
	model.addAttribute("listarUsuariodao", listarUsuariodao);
	
	UsuarioDao  dao2 = new  UsuarioDao();
	List<Usuario> listarUsuario = dao2.pesquisar(usuario);
	model.addAttribute("listarUsuario", listarUsuario);
	
	
	return "Usuario/ListarUsuario";
	
}
	 @RequestMapping("removerUsuario")
	    public String removerUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);
		model.addAttribute("msg", "Usuário Removido com Sucesso !");
		

		return "Usuario/ListarUsuario";
	}

	 @RequestMapping("alterarUsuario")
	    public String alterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("msg", "Usuário alterado com sucesso !");

		return "Usuario/ListarUsuario";
	}
	 
	 @RequestMapping("exibirAlterarUsuario")
	    public String exibirAlterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioPreenchido = dao.buscarPorId(usuario.getId());
		model.addAttribute("usuario", usuarioPreenchido);

		return "usuario/AlterarUsuario";
	}
	 
}