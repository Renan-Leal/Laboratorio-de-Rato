package model.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dao.AgendamentoDAO;
import model.exception.CampoInvalidoException;
import model.exception.ErroNoMetodoException;
import model.exception.PersonalJaPossuiHorarioCadastradoException;
import model.seletor.EnderecoSeletor;
import model.vo.Agendamento;
import model.vo.TipoUsuario;
import model.vo.Usuario;

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
	
	public int contarTotalRegistros(Agendamento agendamento) {
		return dao.contarTotalRegistros(agendamento);
	}

	public boolean recusar(int id) throws CampoInvalidoException {
		return dao.recusar(id);
	}
	
	public boolean aceitar(int id) throws CampoInvalidoException {
		return dao.aceitar(id);
	}

	public boolean verificarSeJaPossuiHorarioComPersonalEscolhido(Integer idProfissional, LocalDateTime horaInicio) throws PersonalJaPossuiHorarioCadastradoException, ErroNoMetodoException {
		return dao.verificarSeJaPossuiHorarioComPersonalEscolhido(idProfissional, horaInicio);
	}

	public ArrayList<Agendamento> buscarAgendamentosUsuarioAutenticado(Usuario usuarioAutenticado) {
		ArrayList<Agendamento> agendamentosBuscados = new ArrayList<Agendamento>();
		
		if(usuarioAutenticado.getTipoUsuario() == TipoUsuario.PERSONAL_TRAINER) {
			agendamentosBuscados =  dao.buscarAgendamentosUsuarioAutenticado(usuarioAutenticado, TipoUsuario.PERSONAL_TRAINER);
		} else if(usuarioAutenticado.getTipoUsuario() == TipoUsuario.CLIENTE) {
			agendamentosBuscados = dao.buscarAgendamentosUsuarioAutenticado(usuarioAutenticado, TipoUsuario.CLIENTE);
			
		}
		return agendamentosBuscados;
	}

}
