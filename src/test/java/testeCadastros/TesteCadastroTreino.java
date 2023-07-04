package testeCadastros;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.vo.Endereco;
import model.vo.NivelTreino;
import model.vo.Pessoa;
import model.vo.TipoUsuario;
import model.vo.Treino;
import model.vo.Usuario;

class TesteCadastroTreino {
	
	private static Usuario personal;
	private static Endereco endereco1;
	private static Pessoa pessoa;
	private static Usuario cliente;
	private static Pessoa pessoa2;
	private static Treino treino;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		endereco1 = new Endereco(1, "Jardim da Silva Neto", "320", "88120300", "apto 102", "Trindade", "Florianopolis", "SC");
		pessoa = new Pessoa(1, endereco1, "Luis Alberto Weber", "123.456.789-11232", "(48)91234-5678", LocalDate.of(2001, 05, 25));
		personal = new Usuario(1, pessoa, TipoUsuario.PERSONAL_TRAINER, 29101, "luis.bertinho@gmail.com", "luis.personal", "5678", 150.00, LocalDateTime.now(), LocalDateTime.now());
		pessoa2 = new Pessoa(2, endereco1, "Barbara Lima", "321.654.978-12", "(48)91453-9823", LocalDate.of(2002, 04, 11));
		cliente = new Usuario(2, pessoa2, TipoUsuario.CLIENTE, 29102, "babalima@gmail.com", "barbara.lima", "3776", 0.00, LocalDateTime.now(), LocalDateTime.now());
		treino = new Treino(1, cliente, personal, LocalDate.of(2023, 06, 01), LocalDate.of(2023, 07, 01), NivelTreino.BASICO, "5m de esteira");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testeTreino() {
		assertEquals(cliente, treino.getCliente(), "CLIENTE INVALIDO");
		assertEquals(personal, treino.getProfissional(), "PERSONAL INVALIDO");
		assertEquals(NivelTreino.BASICO,treino.getNivelTreino(), "NIVEL NÂO SELECIONADO");
		assertEquals("5m de esteira", treino.getTreino(), "TREINO NULO");
	}

}
