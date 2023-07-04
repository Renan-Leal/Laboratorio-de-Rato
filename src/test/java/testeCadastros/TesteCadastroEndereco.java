package testeCadastros;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.vo.Endereco;

class TesteCadastroEndereco{
	
	private static Endereco endereco1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		endereco1 = new Endereco(2, "Jardim da Silva Neto", "320", "88120300", "apto 102", "Trindade", "Florianopolis", "SC");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
//	@Test
//	void testEnderecoFalha() {
//		assertEquals("Jardim da Silva Neto", endereco1.getRua(), "RUA INVALIDA");
//		assertEquals("320", endereco1.getNumero(), "NUMERO INVALIDA");
//		assertEquals("88120300", endereco1.getCep(), "CEP INVALIDA");
//		assertEquals("apto 102", endereco1.getComplemento(), "COMPLEMENTO INVALIDA");
//		assertEquals("Trindade", endereco1.getBairro(), "BAIRRO INVALIDA");
//		assertEquals("Florianopolis", endereco1.getCidade(), "CIDADE INVALIDA");
//		assertEquals("SC", endereco1.getEstado(), "ESTADO INVALIDA");
//	}
	
//	@Test
//	void testEnderecoSucesso() {
//		assertEquals("Jardim da Silva Neto", endereco1.getRua());
//		assertEquals("320", endereco1.getNumero());
//		assertEquals("88120300", endereco1.getCep());
//		assertEquals("apto 102", endereco1.getComplemento());
//		assertEquals("Trindade", endereco1.getBairro());
//		assertEquals("Florianopolis", endereco1.getCidade());
//		assertEquals("SC", endereco1.getEstado());
//	}
	

}
