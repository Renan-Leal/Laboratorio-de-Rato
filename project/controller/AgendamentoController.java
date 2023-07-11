package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bo.AgendamentoBO;
import model.exception.CampoInvalidoException;
import model.exception.ErroNoMetodoException;
import model.exception.PersonalJaPossuiHorarioCadastradoException;
import model.gerador.GeradorPlanilha;
import model.vo.Agendamento;
import model.vo.Usuario;

public class AgendamentoController {
	
private AgendamentoBO bo = new AgendamentoBO();
	
	public Agendamento inserir(Agendamento novoAgendamento) throws CampoInvalidoException {
		validarCamposObrigatorios(novoAgendamento);
		
		return bo.inserir(novoAgendamento);
	}
	
	private void validarCamposObrigatorios(Agendamento agendamento) throws CampoInvalidoException {
		
		String[] valores = {agendamento.getCliente().getEmail(), agendamento.getProfissional().getEmail(), agendamento.getDataHoraInicio().toString()};
		String[] camposInvalidos = {"Cliente", "Profisional", "Data e Hora"};
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
	
	public boolean recusar(int id) throws CampoInvalidoException {
		return bo.recusar(id);
	}
	
	public boolean aceitar(int id) throws CampoInvalidoException {
		return bo.aceitar(id);
	}
	
	public Agendamento consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Agendamento> consultarTodos() {
		return bo.consultarTodos();
	}
	
	public int contarTotalRegistros(Agendamento agendamento) {
		return bo.contarTotalRegistros(agendamento);
	}
	
	public String gerarPlanilha(ArrayList<Agendamento> agendamentos, String destinoArquivo) throws CampoInvalidoException{
		if(agendamentos == null || destinoArquivo == null || destinoArquivo.trim().isEmpty()) {
			throw new CampoInvalidoException("Preencha todos os campos!");
		}
		GeradorPlanilha gerador = new GeradorPlanilha();
		return gerador.gerarPlanilhaAgendamentos(agendamentos, destinoArquivo);
	}

	public boolean verificarSeJaPossuiHorarioComPersonalEscolhido(Integer idProfissional, LocalDateTime horaInicio) throws PersonalJaPossuiHorarioCadastradoException, ErroNoMetodoException {
		return bo.verificarSeJaPossuiHorarioComPersonalEscolhido(idProfissional, horaInicio);
	}

	public ArrayList<Agendamento> buscarAgendamentosUsuarioAutenticado(Usuario usuarioAutenticado) {
		return bo.buscarAgendamentosUsuarioAutenticado(usuarioAutenticado);
	}

	

}
