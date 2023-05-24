package model.bo;

import java.util.List;

import model.dao.EnderecoDAO;
import model.exception.EnderecoInvalidoException;
import model.vo.Endereco;

public class EnderecoBO {

	private EnderecoDAO dao = new EnderecoDAO();
	
	public Endereco inserir(Endereco novoEndereco) {
		return dao.inserir(novoEndereco);
	}
	
	public boolean atualizar(Endereco enderecoAlterado){
		return dao.atualizar(enderecoAlterado);
	}
	
	public boolean excluir(int id) throws EnderecoInvalidoException {	
		return dao.excluir(id);
	}
	
	public Endereco consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Endereco> consultarTodos() {
		return dao.consultarTodos();
	}
}
