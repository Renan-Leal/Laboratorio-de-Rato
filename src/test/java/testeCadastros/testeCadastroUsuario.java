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

class testeCadastroUsuario {
	
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
		usuario2 = new Usuario(2, pessoa2, TipoUsuario.CLIENTE, 29102, "babalima@gmail.com", "barbara.lima", "3776", 0.00, LocalDateTime.now(), LocalDateTime.now());
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
//	@Test
//	void testeCadastroUsuarioFalha2() {
//		assertEquals("Barbara Lima", usuario2.getPessoa().getNome());
//		assertEquals("321.654.978-12", usuario2.getPessoa().getCpf());	
//		assertEquals("(48)91453-9823", usuario2.getPessoa().getTelefone());
//		assertEquals("Jardim da Silva Neto", usuario2.getPessoa().getEndereco().getRua());
//		assertEquals("babalima@gmail.com", usuario2.getEmail());	
//		assertEquals("barbara.lima", usuario2.getLogin());	
//		assertEquals("3776", usuario2.getSenha());	
//		assertEquals(29102, usuario2.getMatricula());	
//		assertEquals(0.00, usuario2.getValorHora());	
//		assertNotEquals(TipoUsuario.CLIENTE, usuario2.getTipoUsuario());	
//		assertEquals(LocalDate.of(2002, 04, 11), usuario2.getPessoa().getDtNascimento());	
//		}
	
//	@Test
//	void testeCadastroUsuarioFalha() {
//		assertEquals("Luis Alberto Weber", usuario.getPessoa().getNome());
//		assertEquals("123.456.789-11", usuario.getPessoa().getCpf(), "CPF INVALIDO");	
//		assertEquals("(48)91234-5678", usuario.getPessoa().getTelefone());
//		assertEquals("Jardim da Silva Neto", usuario.getPessoa().getEndereco().getRua());
//		assertEquals("luis.bertinho@gmail.com", usuario.getEmail());	
//		assertEquals("luis.personal", usuario.getLogin());	
//		assertEquals("5678", usuario.getSenha());	
//		assertEquals(29101, usuario.getMatricula());	
//		assertEquals(150.00, usuario.getValorHora());	
//		assertEquals(TipoUsuario.PERSONAL_TRAINER, usuario.getTipoUsuario());	
//		assertEquals(LocalDate.of(2001, 05, 25), usuario.getPessoa().getDtNascimento());	
//		}

//	@Test
//	void testeCadastroUsuarioSucesso() {
//		assertEquals("Luis Alberto Weber", usuario.getPessoa().getNome());
//		assertEquals("123.456.789-11", usuario.getPessoa().getCpf());	
//		assertEquals("(48)91234-5678", usuario.getPessoa().getTelefone());
//		assertEquals("Jardim da Silva Neto", usuario.getPessoa().getEndereco().getRua());
//		assertEquals("luis.bertinho@gmail.com", usuario.getEmail());	
//		assertEquals("luis.personal", usuario.getLogin());	
//		assertEquals("5678", usuario.getSenha());	
//		assertEquals(29101, usuario.getMatricula());	
//		assertEquals(150.00, usuario.getValorHora());	
//		assertEquals(TipoUsuario.PERSONAL_TRAINER, usuario.getTipoUsuario());	
//		assertEquals(LocalDate.of(2001, 05, 25), usuario.getPessoa().getDtNascimento());	
//		}

}
