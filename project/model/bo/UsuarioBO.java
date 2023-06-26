package model.bo;

import java.util.List;

import javax.swing.ComboBoxModel;

import model.dao.UsuarioDAO;
import model.exception.CampoInvalidoException;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;

public class UsuarioBO {
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario inserir(Usuario novoUsuario) {
		return dao.inserir(novoUsuario);
	}
	
	public boolean atualizar(Usuario usuarioAlterado){
		return dao.atualizar(usuarioAlterado);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {	
		return dao.excluir(id);
	}
	
	public Usuario consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Usuario> consultarTodos() {
		return dao.consultarTodos();
	}

	public Usuario consultarPorLoginSenha(String login, String senha) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioConsultado = usuarioDAO.consultarPorLoginSenha(login, senha);  
		
		return usuarioConsultado;
	}
	
	public int contarTotalRegistrosComFiltros(UsuarioSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);
	}

	public List<Usuario> consultarComFiltros(UsuarioSeletor seletor) {
		return dao.consultarComFiltros(seletor);
	}

	public List<Usuario> consultarPorTipoUsuario(Integer tipoUsuario) {
		
		return dao.consultarPorTipoUsuario(tipoUsuario);
	}

}
