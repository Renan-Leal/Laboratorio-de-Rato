package controller;

import java.util.List;

import model.bo.PessoaBO;
import model.exception.CampoInvalidoException;
import model.vo.Pessoa;

public class PessoaController {
	
	private PessoaBO bo = new PessoaBO();
	
	public Pessoa inserir(Pessoa novaPessoa) throws CampoInvalidoException {
		validarCamposObrigatorios(novaPessoa);
		
		return bo.inserir(novaPessoa);
	}
	
	private void validarCamposObrigatorios(Pessoa pessoa) throws CampoInvalidoException {
		
		String[] valores = {pessoa.getNome(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getDtNascimento().toString()};
		String[] camposInvalidos = {"Nome", "Cpf", "Telefone", "dtNascimento"};
		
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
	

	public boolean atualizar(Pessoa pessoaAlterada) throws CampoInvalidoException{
		validarCamposObrigatorios(pessoaAlterada);
		return bo.atualizar(pessoaAlterada);
	}
	
	public boolean excluir(int id) throws CampoInvalidoException {
		return bo.excluir(id);
	}
	
	public Pessoa consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Pessoa> consultarTodos() {
		return bo.consultarTodos();
	}

	public Pessoa consultarPorCpf(Pessoa pessoa) throws CampoInvalidoException  {
		validarCamposObrigatorios(pessoa);
		return bo.consultarPorCpf(pessoa.getCpf());
	}

}
