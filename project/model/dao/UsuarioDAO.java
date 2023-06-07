package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.TipoUsuario;
import model.vo.Usuario;

public class UsuarioDAO {
	
	public Usuario inserir(Usuario novoUsuario) {
		//Conectar ao banco
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO USUARIO (ID_PESSOA, ID_TIPOUSUARIO, MATRICULA, "
					+ " VALORHORA, EMAIL, LOGIN, SENHA, DT_CADASTRO) "
				    + " VALUES (?,?,?,?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
		//executar o INSERT
		try {
			query.setInt(1, novoUsuario.getPessoa().getId());
			query.setInt(2, novoUsuario.getTipoUsuario().getValor());
			query.setInt(3, novoUsuario.getMatricula());
			query.setDouble(4, novoUsuario.getValorHora());
			query.setString(5, novoUsuario.getEmail());
			query.setString(6, novoUsuario.getLogin());
			query.setString(7, novoUsuario.getSenha());
			query.setObject(8, novoUsuario.getDataCadastro());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoUsuario.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar usuário. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			//Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novoUsuario;
	}
	
	public boolean atualizar(Usuario usuarioEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE USUARIO "
				   + " SET ID_PESSOA = ?, ID_TIPOUSUARIO = ?, MATRICULA = ?, "
				   + " VALORHORA = ?, EMAIL = ?, LOGIN = ?, SENHA = ?"
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, usuarioEditado.getPessoa().getId());
			query.setInt(2, usuarioEditado.getTipoUsuario().getValor());
			query.setInt(3, usuarioEditado.getMatricula());
			query.setDouble(4, usuarioEditado.getValorHora());
			query.setString(5, usuarioEditado.getEmail());
			query.setString(6, usuarioEditado.getLogin());
			query.setString(7, usuarioEditado.getSenha());
			query.execute();
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar usuario. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return atualizou;
	}
	
	public Usuario consultarPorId(int id) {
		Usuario usuarioConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM USUARIO "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				usuarioConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar usuario com id: + " + id 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return usuarioConsultado;
	}
	
	private Usuario converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Usuario pessoaConsultada = new Usuario();
		PessoaDAO pessoa = new PessoaDAO();
		pessoaConsultada.setId(resultado.getInt("id"));
		pessoaConsultada.setPessoa(pessoa.consultarPorId(resultado.getInt("ID_PESSOA")));;
		pessoaConsultada.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(resultado.getInt("ID_TIPOUSUARIO")));
		pessoaConsultada.setMatricula(resultado.getInt("MATRICULA"));
		pessoaConsultada.setValorHora(resultado.getDouble("VALORHORA"));
		pessoaConsultada.setEmail(resultado.getString("EMAIL"));
		pessoaConsultada.setLogin(resultado.getString("LOGIN"));
		pessoaConsultada.setSenha(resultado.getString("SENHA"));
		return pessoaConsultada;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM USUARIO "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir usuario. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}
	
	public List<Usuario> consultarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM USUARIO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Usuario usuarioConsultado = converterDeResultSetParaEntidade(resultado);
				usuarios.add(usuarioConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas os usuarios" 
								+ "\n Causa: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return usuarios;
	}

}