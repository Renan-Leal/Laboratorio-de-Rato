package model.bo;

import java.util.List;

import model.dao.PessoaDAO;
import model.exception.CampoInvalidoException;
import model.vo.Pessoa;

public class PessoaBO {
	
	private PessoaDAO dao = new PessoaDAO();
	
	public Pessoa inserir(Pessoa novaPessoa) {
		return dao.inserir(novaPessoa);
	}
	
	public boolean atualizar(Pessoa pessoaAlterada){
		return dao.atualizar(pessoaAlterada);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {	
		return dao.excluir(id);
	}
	
	public Pessoa consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Pessoa> consultarTodos() {
		return dao.consultarTodos();
	}

}
