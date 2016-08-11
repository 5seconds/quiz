package br.com.fiveseconds.quiz.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiveseconds.quiz.dao.UsuarioDao;
import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

@Controller
public class UsuarioController {
	
	//Feito!
	@RequestMapping("/ExibirIndex")
	public String ExibirIndex() {
		
	return "PaginaPrincipal/index";
	}
	
	//Feito!
	@RequestMapping("/ExibirCadastrarUsuario")
	public String ExibirCadastrarUsuario(Model model) {
			
	return "Usuario/CadastroUsuario";
	}
	//Feito!
	@RequestMapping("CadastrarUsuario")
	public String CadastrarUsuario(@Valid Usuario usuario , Model model) throws SQLException {
		
		
	UsuarioDao dao = new UsuarioDao();
	TipoUsuario tipoUsuario = new TipoUsuario();
	tipoUsuario.setId(1);
	usuario.setTipoUsuario(tipoUsuario);
	
	dao.salvar(usuario);
	dao.fecharConexao();
	model.addAttribute("mensagem", "Cadastro Realizado com Sucesso");
	return "Usuario/CadastroUsuario";
	}


		@RequestMapping("/ExibirAlterarUsuario")
		public String ExibirAlterarUsuario(Model model) {
				
		return "Usuario/AlterarUsuario";
		}
	  @RequestMapping("/exibirAlterarUsuario")
	    public String exibirAlterarUsuario(Model model, Usuario usuario) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		usuario = dao.buscarPorId(usuario.getId());
		model.addAttribute("usuario", usuario);
		dao.fecharConexao();

		return "Usuario/ListarUsuario";
	    }
	  
	  
	  
	  
	    
	    @RequestMapping("alterarUsuario")
	    public String alterarProduto(Usuario usuario1, Model model) throws SQLException {

	    UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario1);
		model.addAttribute("usuario1", usuario1);
		model.addAttribute("mensagem", "Usuario Alterado com Sucesso");
		dao.fecharConexao();

		return "Usuario/AlterarUsuario";
	    }
	
	    
	  //Exibi na tela  
	@RequestMapping("/ExibirListarUsuario")
	public String ExibirListarUsuario(Model model) {
				
		return "Usuario/ListarUsuario";
		}
	
	//Joga para o DAO
	@RequestMapping("listarUsuario")
	public String listarUsuario(Model model) throws SQLException {
		
	UsuarioDao dao = new UsuarioDao();
	List<Usuario> listaUsuario = dao.listar();
	model.addAttribute("listaUsuario", listaUsuario);
	dao.fecharConexao();

	
	return "Usuario/ListarUsuario";
	}
	
	
	
	
	//Feito !
		@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) throws SQLException {
		
		UsuarioDao dao = new UsuarioDao();
	dao.remover(usuario);
	model.addAttribute("msg", "Produto removido com sucesso");
	dao.fecharConexao();

	
	return "forward:listarUsuario";
	}
	
	

	
}
