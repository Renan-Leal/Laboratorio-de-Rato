package executavel;

import model.dao.EnderecoDAO;
import model.dao.PessoaDAO;
import model.vo.Endereco;
import model.vo.Pessoa;

public class executavel {

	public static void main(String[] args) {
		//TESTE
		Endereco e1 = new Endereco(null, "Rua Bolinho", "724","88123467", "Faculdade", "Centro", "Florianopolis", "SC");
		Endereco e2 = new Endereco(null, "Rua Jujuba", "198","88510722", "Casa 3", "Trindade", "Florianopolis", "SC");
		Endereco e3 = new Endereco(null, "Rua Chocolate", "381","88166423", "Apto 301", "Kobrasol", "Sao Jose", "SC");
		
		EnderecoDAO cadastrarEndereco = new EnderecoDAO();
		cadastrarEndereco.inserir(e1);
		cadastrarEndereco.inserir(e2);
		cadastrarEndereco.inserir(e3);
		
		Pessoa p1 = new Pessoa(null, e1, "Renan Leal", "12345678911", "4812346577", "12032001");
		PessoaDAO cadastrarPessoa = new PessoaDAO();
		cadastrarPessoa.inserir(p1);
		
//		Endereco enderecoConsultado = cadastrarEndereco.consultarPorId(1);
//		enderecoConsultado.setBairro("Trindade");
//		boolean atualizou = cadastrarEndereco.atualizar(enderecoConsultado);		
//		if (atualizou) {
//			System.out.println("Endereco atualizado com sucesso.");
//		}
		Pessoa pessoaConsultada = cadastrarPessoa.consultarPorId(1);
		pessoaConsultada.setNome("Renan Roberto Leal");
		boolean atualizou = cadastrarPessoa.atualizar(pessoaConsultada);		
		if (atualizou) {
			System.out.println("Pessoa atualizada com sucesso.");
		} //VER COM O RENAN
//
//		if (cadastrarEndereco.excluir(2)) {
//			System.out.println("Endereco foi excluido!");
//		}
//		
//		// Consultar Todos
//		for (Endereco endereco : cadastrarEndereco.consultarTodos()) {
//			System.out.println(endereco.getId());
//		}
//		
//		// Consultar pessoa por id
//		System.out.println(cadastrarEndereco.consultarPorId(1).getRua());
//
	}

}
