package model.controller;

import java.util.List;
import model.bo.AgendamentoBO;
import model.exception.CampoInvalidoException;
import model.vo.Agendamento;

public class AgendamentoController {
	
private AgendamentoBO bo = new AgendamentoBO();
	
	public Agendamento inserir(Agendamento novoAgendamento) throws CampoInvalidoException {
		validarCamposObrigatorios(novoAgendamento);
		
		return bo.inserir(novoAgendamento);
	}
	
	private void validarCamposObrigatorios(Agendamento agendamento) throws CampoInvalidoException {
		
		String[] valores = {agendamento.getCliente().getEmail(), agendamento.getProfissional().getEmail()};
		String[] camposInvalidos = {"Cliente", "Profisional"};
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
	

	public boolean atualizar(Agendamento agendamentoAlterado) throws CampoInvalidoException{
		validarCamposObrigatorios(agendamentoAlterado);
		return bo.atualizar(agendamentoAlterado);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {
		return bo.excluir(id);
	}
	
	public Agendamento consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Agendamento> consultarTodos() {
		return bo.consultarTodos();
	}

}