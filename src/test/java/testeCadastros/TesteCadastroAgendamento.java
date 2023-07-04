package testeCadastros;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.vo.Agendamento;
import model.vo.Endereco;
import model.vo.Pessoa;
import model.vo.TipoUsuario;
import model.vo.Usuario;

class TesteCadastroAgendamento {

	private static Usuario personal;
	private static Endereco endereco1;
	private static Pessoa pessoa;
	private static Usuario cliente;
	private static Pessoa pessoa2;
	private static Agendamento agendamento;
	private static String date;
	private static String date2;
	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		date = "2023-04-01 08:00";
		date2 = "2023-04-01 10:00";
		endereco1 = new Endereco(1, "Jardim da Silva Neto", "320", "88120300", "apto 102", "Trindade", "Florianopolis", "SC");
		pessoa = new Pessoa(1, endereco1, "Luis Alberto Weber", "123.456.789-11232", "(48)91234-5678", LocalDate.of(2001, 05, 25));
		personal = new Usuario(1, pessoa, TipoUsuario.PERSONAL_TRAINER, 29101, "luis.bertinho@gmail.com", "luis.personal", "5678", 150.00, LocalDateTime.now(), LocalDateTime.now());
		pessoa2 = new Pessoa(2, endereco1, "Barbara Lima", "321.654.978-12", "(48)91453-9823", LocalDate.of(2002, 04, 11));
		cliente = new Usuario(2, pessoa2, TipoUsuario.CLIENTE, 29102, "babalima@gmail.com", "barbara.lima", "3776", 0.00, LocalDateTime.now(), LocalDateTime.now());
		agendamento = new Agendamento(1,  cliente, personal, false, "", LocalDateTime.parse(date, format), LocalDateTime.parse(date2, format));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testeAgendamento() {
		assertEquals(cliente, agendamento.getCliente(), "CLIENTE INVALIDO");
		assertEquals(personal, agendamento.getProfissional(), "PERSONAL INVALIDOS");
		assertEquals(LocalDateTime.parse(date, format), agendamento.getDataHoraInicio(), "HORA INDISPONIVEL");
		assertEquals(LocalDateTime.parse(date2, format), agendamento.getDataHoraFinal(), "HORA INDISPONIVEL");
	}

}
