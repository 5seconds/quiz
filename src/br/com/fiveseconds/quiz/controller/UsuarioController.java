package br.com.fiveseconds.quiz.controller;

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
	
	
	@RequestMapping("/ExibirIndex")
	public String ExibirIndex() {
		
	return "PaginaPrincipal/index";
	}
	

	@RequestMapping("/ExibirCadastrarUsuario")
	public String ExibirCadastrarUsuario(Model model) {
			
	return "Usuario/CadastroUsuario";
	}
	
	@RequestMapping("CadastrarUsuario")
	public String CadastrarUsuario(@Valid Usuario usuario , Model model) {
		
		
	UsuarioDao dao = new UsuarioDao();
	TipoUsuario tipoUsuario = new TipoUsuario();
	tipoUsuario.setId(1);
	usuario.setTipoUsuario(tipoUsuario);
	
	dao.salvar(usuario);
	model.addAttribute("mensagem", "Cadastro Realizado com Sucesso");
	return "Usuario/CadastroUsuario";
	}

	  @RequestMapping("/exibirAlterarUsuario")
	    public String exibirAlterarUsuario(Model model, Usuario usuario) {

		UsuarioDao dao = new UsuarioDao();
		usuario = dao.buscarPorId(usuario.getId());
		model.addAttribute("usuario", usuario);

		return "Usuario/AlterarUsuario";
	    }
	    
	    @RequestMapping("alterarUsuario")
	    public String alterarProduto(Usuario usuario1, Model model) {

	    UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario1);
		model.addAttribute("usuario1", usuario1);
		model.addAttribute("mensagem", "Usuario Alterado com Sucesso");
		
		return "Usuario/AlterarUsuario";
	    }
	
	
	@RequestMapping("listarUsuario")
	public String listarUsuario(Model model) {
		
		UsuarioDao dao = new UsuarioDao();
	List<Usuario> listaUsuario = dao.listar();
	model.addAttribute("listaUsuario", listaUsuario);
	
	return "Usuario/ListarUsuario";
	}
	
	
	
	@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) {
		
		UsuarioDao dao = new UsuarioDao();
	dao.remover(usuario);
	model.addAttribute("msg", "Produto removido com sucesso");
	
	return "forward:listarUsuario";
	}
	
	

	
}
