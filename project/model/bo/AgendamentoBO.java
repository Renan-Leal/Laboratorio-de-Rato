package model.bo;

import java.util.List;

import model.dao.AgendamentoDAO;
import model.exception.CampoInvalidoException;
import model.vo.Agendamento;

public class AgendamentoBO {
	
private AgendamentoDAO dao = new AgendamentoDAO();
	
	public Agendamento inserir(Agendamento novoAgendamento) {
		return dao.inserir(novoAgendamento);
	}
	
	public boolean atualizar(Agendamento agendamentoAlterado){
		return dao.atualizar(agendamentoAlterado);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {	
		return dao.excluir(id);
	}
	
	public Agendamento consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Agendamento> consultarTodos() {
		return dao.consultarTodos();
	}

}
