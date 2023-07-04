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

import model.vo.Pessoa;

public class PessoaDAO {
	
	public Pessoa inserir(Pessoa novaPessoa) {
		//Conectar ao banco
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO PESSOA (NOME, CPF, TELEFONE, "
					+ " DT_NASCIMENTO, ID_ENDERECO) "
				    + " VALUES (?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		Pessoa pessoaConsultadaPorCpf = this.consultarPorCpf(novaPessoa.getCpf());
		
		
		try {
			query.setString(1, novaPessoa.getNome());
			query.setString(2, novaPessoa.getCpf());
			query.setString(3, novaPessoa.getTelefone());
			query.setObject(4, novaPessoa.getDtNascimento());
			query.setInt(5, novaPessoa.getEndereco().getId());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			//Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novaPessoa;
	}
	
	public boolean atualizar(Pessoa pessoaEditada) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE PESSOA "
				   + " SET NOME = ?, CPF = ?, TELEFONE = ?, "
				   + " DT_NASCIMENTO = ?, ID_ENDERECO = ?"
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, pessoaEditada.getNome());
			query.setString(2, pessoaEditada.getCpf());
			query.setString(3, pessoaEditada.getTelefone());
			query.setObject(4, pessoaEditada.getDtNascimento());
			query.setInt(5, pessoaEditada.getEndereco().getId());
			query.setInt(6, pessoaEditada.getId());
			query.execute();
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return atualizou;
	}
	
	public Pessoa consultarPorId(int id) {
		Pessoa pessoaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaConsultada = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoa com id: + " + id 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoaConsultada;
	}
	
	public Pessoa consultarPorNome(String nome) {
		Pessoa pessoaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
				    + " WHERE NOME = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setString(1, nome);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaConsultada = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoa com nome: + " + nome 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoaConsultada;
	}
	
	public Pessoa consultarPorCpf(String cpf) {
		Pessoa pessoaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
				    + " WHERE CPF = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setString(1, cpf);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaConsultada = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoa com cpf: + " + cpf 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoaConsultada;
	}
	
	private Pessoa converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Pessoa pessoaConsultada = new Pessoa();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		pessoaConsultada.setId(resultado.getInt("ID"));
		pessoaConsultada.setNome(resultado.getString("NOME"));
		pessoaConsultada.setCpf(resultado.getString("CPF"));
		pessoaConsultada.setTelefone(resultado.getString("TELEFONE"));
		pessoaConsultada.setDtNascimento(LocalDate.parse(resultado.getString("DT_NASCIMENTO")));
		pessoaConsultada.setEndereco(enderecoDAO.consultarPorId(resultado.getInt("ID_ENDERECO")));
		return pessoaConsultada;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM PESSOA "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}
	
	public List<Pessoa> consultarTodos() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Pessoa pessoaConsultada = converterDeResultSetParaEntidade(resultado);
				pessoas.add(pessoaConsultada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas as pessoas" 
								+ "\n Causa: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoas;
	}

}
