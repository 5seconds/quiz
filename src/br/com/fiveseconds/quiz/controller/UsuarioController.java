package br.com.fiveseconds.quiz.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/ExibirCadastroUsuarioADM")
	public String ExibirCadastrarUsuarioADM(Model model) {

		return "Usuario/CadastroUsuarioADM";
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
	
	@RequestMapping("CadastrarUsuarioADM")
	public String CadastrarUsuarioADM(@Valid Usuario usuario, Model model)
			throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {

		UsuarioDao dao = new UsuarioDao();
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(1);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setSenha(Criptografia.sha1(usuario.getSenha()));

		dao.salvar(usuario);
		dao.fecharConexao();
		model.addAttribute("mensagem", "Cadastro Realizado com Sucesso");
		return "Usuario/CadastroUsuarioADM";
	}

	@RequestMapping("/ExibirListarUsuario")
	public String ExibirListarUsuario(Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listarUsuario = dao.listar();
		model.addAttribute("listarUsuario", listarUsuario);
		dao.fecharConexao();
		return "Usuario/ListarUsuario";
	}

	@RequestMapping("/PesquisarUsuario")
	public @ResponseBody String pesquisarUsuario(@RequestParam String nome, @RequestParam String email,
			HttpServletResponse response) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listarUsuario = dao.pesquisar(nome, email);

		StringBuilder st = new StringBuilder();
		st.append("<center>");
		st.append("<table class='tabela' border='0' style='width: 80%; text-align: center'>");
		st.append("<thead>");
		st.append("<tr>");
		st.append("<th class='linha'> ID </th>");
		st.append("<th class='linha' > NOME  </th>");
		st.append("<th class='linha'> EMAIL  </th>");
		st.append("<th class='linha'> AÇÕES  </th>");
		st.append("</tr>");
		st.append("<thead>");
		
		for (Usuario usuario : listarUsuario) {
			st.append("<tr>");
			st.append("<td class='linha2'> " + usuario.getId() + " </td>");
			st.append("<td class='linha2'> " + usuario.getNome() + " </td>");
			st.append("<td class='linha2'> " + usuario.getEmail() + " </td>");
			st.append("<td class='linha2'>");
			st.append("<a href='removerUsuario?id=" + usuario.getId() + "'class='btn btn-danger' role='button'> R </a>");
			st.append("</td>");
			st.append("</tr>");
			
		}
		st.append("</table>");
		st.append("</center>");
		
		
		response.setStatus(200);
		dao.fecharConexao();
		return st.toString();

	}

	@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);
		model.addAttribute("msg", "Usuário Removido");
		dao.fecharConexao();

		return "forward:ExibirListarUsuario";
	}

	/*@RequestMapping("alterarUsuario")
	public String alterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("msg", "Usuário alterado com sucesso !");
		
		return "forward:ExibirListarUsuario";
	}

	@RequestMapping("exibirAlterarUsuario")
	public String exibirAlterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioPreenchido = dao.buscarPorId(usuario.getId());
		model.addAttribute("usuario", usuarioPreenchido);

		return "Usuario/AlterarUsuario";
	}
    */
}