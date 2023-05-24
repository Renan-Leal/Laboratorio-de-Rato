package model.controller;

import java.util.List;

import model.bo.EnderecoBO;
import model.exception.CampoInvalidoException;
import model.exception.EnderecoInvalidoException;
import model.vo.Endereco;

public class EnderecoController {
	
    private EnderecoBO bo = new EnderecoBO();
	
	public Endereco inserir(Endereco novoEndereco) throws CampoInvalidoException {
		validarCamposObrigatorios(novoEndereco);
		
		return bo.inserir(novoEndereco);
	}
	
	private void validarCamposObrigatorios(Endereco endereco) throws CampoInvalidoException {
		
		String[] valores = {endereco.getCep(), endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado()};
		String[] camposInvalidos = {"CEP", "Rua", "Número", "Bairro", "Cidade", "Estado"};
		
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
	

	public boolean atualizar(Endereco enderecoAlterado) throws CampoInvalidoException{
		validarCamposObrigatorios(enderecoAlterado);
		return bo.atualizar(enderecoAlterado);
	}
	
	public boolean excluir(int id) throws EnderecoInvalidoException {
		return bo.excluir(id);
	}
	
	public Endereco consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Endereco> consultarTodos() {
		return bo.consultarTodos();
	}

}
