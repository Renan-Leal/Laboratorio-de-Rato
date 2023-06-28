package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.seletor.TreinoSeletor;
import model.vo.Agendamento;
import model.vo.NivelTreino;
import model.vo.Treino;

public class TreinoDAO {
	public Treino inserir(Treino novoTreino) {

		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO TREINO (ID_CLIENTE, ID_PROFISSIONAL, DT_CADASTRO, "
				+ " DT_TERMINO, ID_NIVELTREINO, TREINO) " + " VALUES (?,?,?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		// executar o INSERT
		try {
			query.setInt(1, novoTreino.getCliente().getId());
			query.setInt(2, novoTreino.getProfissional().getId());
			query.setObject(3, novoTreino.getDtCadastro());
			query.setObject(4, novoTreino.getDtTermino());
			query.setInt(5, novoTreino.getNivelTreino().getValor());
			query.setString(6, novoTreino.getTreino());
			query.execute();

			// Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if (resultado.next()) {
				novoTreino.setId(resultado.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir treino. " + "\nCausa: " + e.getMessage());
		} finally {
			// Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return novoTreino;
	}

	public boolean atualizar(Treino treinoEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE TREINO " + " SET ID_CLIENTE = ?, ID_PROFISSIONAL = ?, DT_CADASTRO = ?, "
				+ " DT_TERMINO = ?, ID_NIVELTREINO = ?, TREINO = ?" + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, treinoEditado.getCliente().getId());
			query.setInt(2, treinoEditado.getProfissional().getId());
			query.setObject(3, treinoEditado.getDtCadastro());
			query.setObject(4, treinoEditado.getDtTermino());
			query.setInt(5, treinoEditado.getNivelTreino().getValor());
			query.setString(6, treinoEditado.getTreino());
			query.setInt(7, treinoEditado.getId());
			query.execute();

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar treino. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return atualizou;
	}

	public Treino consultarPorId(int id) {
		Treino treinoConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM TREINO " + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				treinoConsultado = montarTreinoComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar treino com id: + " + id + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinoConsultado;
	}

	private Treino montarTreinoComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Treino treinoConsultado = new Treino();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		treinoConsultado.setId(resultado.getInt("ID"));
		treinoConsultado.setProfissional(usuarioDao.consultarPorId(resultado.getInt("ID_PROFISSIONAL")));
		treinoConsultado.setCliente(usuarioDao.consultarPorId(resultado.getInt("ID_CLIENTE")));
		try {
			treinoConsultado.setDtCadastro(LocalDate.parse(resultado.getString("DT_CADASTRO")));
			treinoConsultado.setDtTermino(LocalDate.parse(resultado.getString("DT_TERMINO")));
		} catch (Exception e) {
			treinoConsultado.setDtCadastro(null);
			treinoConsultado.setDtTermino(null);

		}

		treinoConsultado.setNivelTreino(NivelTreino.getNivelTreinoPorValor(resultado.getInt("ID_NIVELTREINO")));
		treinoConsultado.setTreino(resultado.getString("TREINO"));
		return treinoConsultado;
	}

	public boolean excluir(int id) {
		boolean excluiu = false;

		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM TREINO " + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir treino. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public List<Treino> consultarTodos() {
		List<Treino> treinos = new ArrayList<Treino>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM TREINO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Treino treinoConsultado = montarTreinoComResultadoDoBanco(resultado);
				treinos.add(treinoConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os treinos" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinos;
	}

	public List<Treino> consultarComFiltros(TreinoSeletor seletor) {
		List<Treino> treinos = new ArrayList<Treino>();
		Connection conexao = Banco.getConnection();
		String sql = " select * from TREINO ";

//		if(seletor.temFiltro()) {
//			sql = preencherFiltros(sql, seletor);
//		}
//		
//		if(seletor.temPaginacao()) {
//			sql += " LIMIT "  + seletor.getLimite()
//				 + " OFFSET " + seletor.getOffset();  
//		}

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			while (resultado.next()) {
				Treino treinoBuscado = montarTreinoComResultadoDoBanco(resultado);
				treinos.add(treinoBuscado);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os treinos. \n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinos;
	}

//	private String preencherFiltros(String sql, TreinoSeletor seletor) {
//		boolean primeiro = true;
//		if(seletor.getCliente() != 0) {
//			if(primeiro) {
//				sql += " WHERE ";
//			} else {
//				sql += " AND ";
//			}
//			
//			sql += " ID_CLIENTE = " + seletor.getCliente();
//			primeiro = false;
//		}
//		
//		if(seletor.getProfissional() != 0) {
//			if(primeiro) {
//				sql += " WHERE ";
//			} else {
//				sql += " AND ";
//			}
//			sql += " ID_PROFISSIONAL = " + seletor.getProfissional();
//			primeiro = false;
//		}
//		
//		if(seletor.getNivel() != 0) {
//			if(primeiro) {
//				sql += " WHERE ";
//			} else {
//				sql += " AND ";
//			}
//			sql += " ID_NIVELTREINO =" + seletor.getNivel();
//			primeiro = false;
//		}
//		return sql;
//	}

	public int contarTotalRegistrosComFiltros(TreinoSeletor seletor) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from TREINO ";

//		if(seletor.temFiltro()) {
//			sql = preencherFiltros(sql, seletor);
//		}

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				total = resultado.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Erro contar o total de treinos" + "\n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return total;
	}

	public ArrayList<Treino> consultarTreinosUsuarioAutenticado(Integer id) {

		ArrayList<Treino> treinos = new ArrayList<Treino>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT \r\n" + "	TREINO.ID AS ID\r\n" + "    , TREINO.ID_CLIENTE\r\n"
				+ "    , TREINO.ID_PROFISSIONAL\r\n" + "    , TREINO.ID_NIVELTREINO\r\n"
				+ "    , TREINO.DT_CADASTRO\r\n" + "    , TREINO.DT_TERMINO\r\n" + "    , TREINO.TREINO\r\n"
				+ "FROM\r\n" + "	TREINO\r\n" + "INNER JOIN USUARIO ON\r\n" + "	TREINO.ID_CLIENTE = USUARIO.ID\r\n"
				+ "INNER JOIN PESSOA ON\r\n" + "	USUARIO.ID_PESSOA = PESSOA.ID\r\n" + "WHERE ID_PROFISSIONAL = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Treino treinoConsultado = montarTreinoComResultadoDoBanco(resultado);
				treinos.add(treinoConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os treinos" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinos;
	}

	public boolean conectarClienteAoProfissional(Agendamento novoAgendamento) {
		Boolean conexaoClienteProfissional = false;
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO TREINO (ID_CLIENTE, ID_PROFISSIONAL)" + " VALUES (?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		// executar o INSERT
		try {
			query.setInt(1, novoAgendamento.getCliente().getId());
			query.setInt(2, novoAgendamento.getProfissional().getId());
			query.execute();
			// Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if (resultado.next()) {
				novoAgendamento.setId(resultado.getInt(1));
			}
			conexaoClienteProfissional = true;

		} catch (SQLException e) {
			System.out.println(
					"Erro ao inserir conexão entre o profissional e o cliente. " + "\nCausa: " + e.getMessage());
		} finally {
			// Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return conexaoClienteProfissional;
	}

	public Integer verificarExistenciaDoCadastro(Treino treino) {
		Treino treinoConsultado = new Treino();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM TREINO " + " WHERE ID_CLIENTE = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, treino.getCliente().getId());
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				treinoConsultado = montarTreinoComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println(
					"Erro ao buscar cliente com id: + " + treino.getCliente().getId() + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinoConsultado.getId();
	}

}
