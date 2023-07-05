package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.controller.TreinoController;
import model.exception.ErroNoMetodoException;
import model.exception.PersonalJaPossuiHorarioCadastradoException;
import model.seletor.EnderecoSeletor;
import model.vo.Agendamento;
import model.vo.TipoUsuario;
import model.vo.Usuario;

public class AgendamentoDAO {
	
	public Agendamento inserir(Agendamento novoAgendamento) {
		
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO AGENDAMENTO (ID_CLIENTE, ID_PROFISSIONAL, "
		+ " DATAHORA_INICIO, DATAHORA_FINAL) "
				+ " VALUES (?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		// executar o INSERT
		try {
			query.setInt(1, novoAgendamento.getCliente().getId());
			query.setInt(2, novoAgendamento.getProfissional().getId());
//			query.setBoolean(3, novoAgendamento.getAceito());
//			query.setString(4, novoAgendamento.getMotivoRejeicao());
			query.setObject(3, novoAgendamento.getDataHoraInicio());
			query.setObject(4, novoAgendamento.getDataHoraFinal());
			query.execute();

			// Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if (resultado.next()) {
				novoAgendamento.setId(resultado.getInt(1));
			}
			
			

		} catch (SQLException e) {
			System.out.println("Erro ao inserir treino. " + "\nCausa: " + e.getMessage());
		} finally {
			// Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return novoAgendamento;
	}

	public boolean atualizar(Agendamento agendamentoEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE AGENDAMENTO " + " SET ID_CLIENTE = ?, ID_PROFISSIONAL = ?, ACEITO = ?, "
				+ " MOTIVO_REJEICAO = ?, DATAHORA_INICIO = ?, DATAHORA_FINAL = ?" + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, agendamentoEditado.getCliente().getId());
			query.setInt(2, agendamentoEditado.getProfissional().getId());
			query.setObject(3, agendamentoEditado.getAceito());
			query.setString(4, agendamentoEditado.getMotivoRejeicao());
			query.setObject(5, agendamentoEditado.getDataHoraInicio());
			query.setObject(6, agendamentoEditado.getDataHoraFinal());
			query.setInt(7, agendamentoEditado.getId());
			query.execute();

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar agendamento. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return atualizou;
	}

	public Agendamento consultarPorId(int id) {
		Agendamento agendamentoConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM AGENDAMENTO " + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				agendamentoConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar agendamento com id: + " + id + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return agendamentoConsultado;
	}

	private Agendamento converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Agendamento agendamentoConsultado = new Agendamento();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		agendamentoConsultado.setId(resultado.getInt("ID"));
		agendamentoConsultado.setProfissional(usuarioDao.consultarPorId(resultado.getInt("ID_PROFISSIONAL")));
		agendamentoConsultado.setCliente(usuarioDao.consultarPorId(resultado.getInt("ID_CLIENTE")));
		agendamentoConsultado.setDataHoraInicio(LocalDateTime.parse(resultado.getString("DATAHORA_INICIO"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));;
		agendamentoConsultado.setDataHoraFinal(LocalDateTime.parse(resultado.getString("DATAHORA_FINAL"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//		agendamentoConsultado.setAceito(resultado.getBoolean("ACEITO"));;
//		agendamentoConsultado.setMotivoRejeicao(resultado.getString("MOTIVO_REJEICAO"));
		return agendamentoConsultado;
	}

	public boolean excluir(int id) {
		boolean excluiu = false;

		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM AGENDAMENTO " + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir agendamento. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public List<Agendamento> consultarTodos() {
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM AGENDAMENTO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Agendamento agendamentoConsultado = converterDeResultSetParaEntidade(resultado);
				agendamentos.add(agendamentoConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os agendamentos" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return agendamentos;
	}
	
	public int contarTotalRegistros(Agendamento agendamento) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from ENDERECO ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				total = resultado.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("Erro contar o total de agendamentos" 
					+ "\n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return total;
	}

	public boolean recusar(int id) {
		boolean recusado = false;

		Connection conexao = Banco.getConnection();
		String sql = " UPDATE AGENDAMENTO " + " SET ACEITO = ?, "
				+ " MOTIVO_REJEICAO = ?" + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			recusado = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao recusar o agendamento. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return recusado;
	}
	
	public boolean aceitar(int id) {
		boolean aceito = false;

		Connection conexao = Banco.getConnection();
		String sql = " UPDATE AGENDAMENTO " + " SET ACEITO = ?, "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			aceito = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao aceitar o agendamento. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return aceito;
	}

	public boolean verificarSeJaPossuiHorarioComPersonalEscolhido(Integer idProfissional, LocalDateTime horaInicio) throws PersonalJaPossuiHorarioCadastradoException, ErroNoMetodoException {
		boolean possuiHorarioAgendado = false; 
		Connection conexao = Banco.getConnection();
		String sql = "SELECT COUNT(*) AS TOTAL_REGISTROS\r\n"
				+ "FROM\r\n"
				+ "	AGENDAMENTO\r\n"
				+ "WHERE AGENDAMENTO.ID_PROFISSIONAL = ? AND AGENDAMENTO.DATAHORA_INICIO = ?";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		
		try {
			query.setInt(1, idProfissional);
			query.setObject(2, horaInicio);
			ResultSet resultado = query.executeQuery();
			
			
			if(resultado.next() && resultado.getInt("TOTAL_REGISTROS") == 1) {
				possuiHorarioAgendado = true;
				throw new PersonalJaPossuiHorarioCadastradoException("Outro cliente já agendou este horário! Escolha outro!");
			}
			
		} catch (Exception e) {
			throw new ErroNoMetodoException("Erro ao executar o método verificar verificarSeJaPossuiHorarioComPersonalEscolhido\nCausa: " + e.getMessage());
			
		}
		return possuiHorarioAgendado;
	}

	

	public ArrayList<Agendamento> buscarAgendamentosUsuarioAutenticado(Usuario usuarioAutenticado, TipoUsuario tipoUsuario) {
		ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
		String sql = new String();
		
		if (tipoUsuario == TipoUsuario.PERSONAL_TRAINER) {
			sql = "SELECT * FROM AGENDAMENTO WHERE ID_PERSONAL= ?";
		} else if (tipoUsuario == TipoUsuario.CLIENTE) {
			sql = "SELECT * FROM AGENDAMENTO WHERE ID_CLIENTE = ?";
		}
		
		Connection conexao = Banco.getConnection();
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, usuarioAutenticado.getId());
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Agendamento agendamentoConsultado = converterDeResultSetParaEntidade(resultado);
				agendamentos.add(agendamentoConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os agendamentos" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		
		return agendamentos;
		
	}

}
