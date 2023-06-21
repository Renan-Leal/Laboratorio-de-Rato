package model.controller;

import java.util.List;

import model.bo.UsuarioBO;
import model.exception.CampoInvalidoException;
import model.vo.Usuario;

public class UsuarioController {

	private UsuarioBO bo = new UsuarioBO();

	public Usuario inserir(Usuario novoUsuario) throws CampoInvalidoException {
		validarCamposObrigatorios(novoUsuario);

		return bo.inserir(novoUsuario);
	}

	private void validarCamposObrigatorios(Usuario usuario) throws CampoInvalidoException {

		String[] valores = {usuario.getPessoa().getNome(), usuario.getEmail(), usuario.getLogin(), usuario.getSenha()};
		String[] camposInvalidos = {"Nome", "Email", "Login", "Senha"};
		//n�o consegui fazer com que ele validasse int
		String mensagemValidacao = "";

		for (int i = 0; i < valores.length; i++) {
			mensagemValidacao += validarString(valores[i], camposInvalidos[i]);
		}
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarString(String texto, String nomeCampo) {
		boolean valido = (texto != null) && !texto.trim().isEmpty();

		if(valido) {
			return "";
		}else {
			return 	"- " + nomeCampo + "\n" ;
		}
	}


	public boolean atualizar(Usuario usuarioAlterado) throws CampoInvalidoException{
		validarCamposObrigatorios(usuarioAlterado);
		return bo.atualizar(usuarioAlterado);
	}

	public boolean excluir(int id) throws CampoInvalidoException {
		return bo.excluir(id);
	}

	public Usuario consultarPorId(int id) {
		return bo.consultarPorId(id);
	}

	public List<Usuario> consultarTodos() {
		return bo.consultarTodos();
	}

	public Usuario consultarPorLoginSenha(String login, String senha) throws CampoInvalidoException {
		UsuarioBO usuarioBO =  new UsuarioBO();
		Usuario usuarioConsultado = null;
		boolean valido = (login != null && !login.isEmpty()) && (senha != null && !senha.isEmpty() && senha.length() == 4);
		if (valido) {
			usuarioConsultado = usuarioBO.consultarPorLoginSenha(login, senha);
		} else {

			throw new CampoInvalidoException("Login ou senha inválidos!");

		}

		return usuarioConsultado;
	}


}
