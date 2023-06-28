package testeCadastros;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.vo.Endereco;
import model.vo.Pessoa;
import model.vo.TipoUsuario;
import model.vo.Usuario;

class TesteLogin {

	private static Usuario usuario;
	private static Endereco endereco1;
	private static Pessoa pessoa;
	private static Usuario usuario2;
	private static Pessoa pessoa2;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		endereco1 = new Endereco(1, "Jardim da Silva Neto", "320", "88120300", "apto 102", "Trindade", "Florianopolis", "SC");
		pessoa = new Pessoa(1, endereco1, "Luis Alberto Weber", "123.456.789-11232", "(48)91234-5678", LocalDate.of(2001, 05, 25));
		usuario = new Usuario(1, pessoa, TipoUsuario.PERSONAL_TRAINER, 29101, "luis.bertinho@gmail.com", "luis.personal", "5678", 150.00, LocalDateTime.now(), LocalDateTime.now());
		pessoa2 = new Pessoa(2, endereco1, "Barbara Lima", "321.654.978-12", "(48)91453-9823", LocalDate.of(2002, 04, 11));
		usuario2 = new Usuario(2, pessoa2, TipoUsuario.CLIENTE, 29102, "babalima@gmail.com", "renan.duarte", "0123", 0.00, LocalDateTime.now(), LocalDateTime.now());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testeLogin() {
		assertEquals("renan.leal", usuario2.getLogin(), "LOGIN INVALIDO OU SENHA INVALIDOS");
		assertEquals("1705", usuario2.getSenha(), "LOGIN INVALIDO OU SENHA INVALIDOS");
	}

}
