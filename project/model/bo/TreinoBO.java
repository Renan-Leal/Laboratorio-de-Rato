package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.TreinoDAO;
import model.exception.CampoInvalidoException;
import model.seletor.TreinoSeletor;
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
	
	public int contarTotalRegistrosComFiltros(TreinoSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);
	}

	public List<Treino> consultarComFiltros(TreinoSeletor seletor) {
		return dao.consultarComFiltros(seletor);
	}

	public ArrayList<Treino> consultarTreinosUsuarioAutenticado(Integer id) {
		return dao.consultarTreinosUsuarioAutenticado(id);
	}
		

}
