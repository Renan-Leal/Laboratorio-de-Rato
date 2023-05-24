package Executavel;

import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class executavel {

	public static void main(String[] args) {
		//TESTE
		Endereco e1 = new Endereco(null, "SC", "Florianopolis", "Centro", "Rua Jardim Silva", "724", "Faculdade", "88123467");
		
		EnderecoDAO cadastrarEndereco = new EnderecoDAO();
		cadastrarEndereco.inserir(e1);

	}

}
