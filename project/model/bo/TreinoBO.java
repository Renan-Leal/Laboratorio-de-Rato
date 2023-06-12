package model.bo;

import java.util.List;

import model.dao.TreinoDAO;
import model.exception.CampoInvalidoException;
import model.vo.Treino;

public class TreinoBO {
	
	private TreinoDAO dao = new TreinoDAO();
	
	public Treino inserir(Treino novoTreino) {
		return dao.inserir(novoTreino);
	}
	
	public boolean atualizar(Treino treinoAlterado){
		return dao.atualizar(treinoAlterado);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {	
		return dao.excluir(id);
	}
	
	public Treino consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Treino> consultarTodos() {
		return dao.consultarTodos();
	}
		

}
