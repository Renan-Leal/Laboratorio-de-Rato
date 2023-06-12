Gabriela
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.NivelTreino;
import model.vo.Treino;

public class TreinoDAO {
	public Treino inserir(Treino novoTreino) {

		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO TREINO (ID_CLIENTE, ID_PROFISSIONAL, DT_CADASTRO, " + " DT_TERMINO, NIVEL, TREINO) "
				+ " VALUES (?,?,?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		// executar o INSERT
		try {
			query.setInt(1, novoTreino.getCliente().getId());
			query.setInt(2, novoTreino.getProfissional().getId());
			query.setString(3, novoTreino.getDtCadastro());
			query.setString(4, novoTreino.getDtTermino());
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
				+ " DT_TERMINO = ?, NIVEL = ?, TREINO = ?" + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, treinoEditado.getCliente().getId());
			query.setInt(2, treinoEditado.getProfissional().getId());
			query.setString(3, treinoEditado.getDtCadastro());
			query.setString(4, treinoEditado.getDtTermino());
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
				treinoConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar treino com id: + " + id + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return treinoConsultado;
	}

	private Treino converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Treino treinoConsultado = new Treino();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		treinoConsultado.setId(resultado.getInt("ID"));
		treinoConsultado.setProfissional(usuarioDao.consultarPorId(resultado.getInt("ID_PROFISSIONAL")));
		treinoConsultado.setCliente(usuarioDao.consultarPorId(resultado.getInt("ID_CLIENTE")));
		treinoConsultado.setDtCadastro(resultado.getString("DT_CADASTRO"));
		treinoConsultado.setDtTermino(resultado.getString("DT_TERMINO"));
		treinoConsultado.setNivelTreino(NivelTreino.getNivelTreinoPorValor(resultado.getInt("NIVEL")));
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
				Treino treinoConsultado = converterDeResultSetParaEntidade(resultado);
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

}
main
