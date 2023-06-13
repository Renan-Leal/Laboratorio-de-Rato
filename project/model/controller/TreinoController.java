package model.controller;

import java.util.List;

import model.bo.TreinoBO;
import model.exception.CampoInvalidoException;
import model.vo.Treino;

public class TreinoController {
	
	private TreinoBO bo = new TreinoBO();
	
	public Treino inserir(Treino novoTreino) throws CampoInvalidoException {
		validarCamposObrigatorios(novoTreino);
		
		return bo.inserir(novoTreino);
	}
	
	private void validarCamposObrigatorios(Treino treino) throws CampoInvalidoException {
		
		String[] valores = {treino.getCliente().getEmail(), treino.getProfissional().getEmail(), treino.getDtCadastro(), treino.getDtTermino(),
				treino.getTreino()};
		String[] camposInvalidos = {"Cliente", "Proffisional", "Data Cadastro", "Data Termino", "Treino"};
		//não consegui fazer com que ele validasse int
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
	

	public boolean atualizar(Treino treinoAlterado) throws CampoInvalidoException{
		validarCamposObrigatorios(treinoAlterado);
		return bo.atualizar(treinoAlterado);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {
		return bo.excluir(id);
	}
	
	public Treino consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Treino> consultarTodos() {
		return bo.consultarTodos();
	}

}
