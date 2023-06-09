package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.seletor.UsuarioSeletor;
import model.vo.TipoUsuario;
import model.vo.Usuario;

public class UsuarioDAO {

	public Usuario inserir(Usuario novoUsuario) {
		// Conectar ao banco
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO USUARIO (ID_PESSOA, ID_TIPOUSUARIO, MATRICULA, "
				+ " VALORHORA, EMAIL, LOGIN, SENHA, DT_CADASTRO) " + " VALUES (?,?,?,?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		// executar o INSERT
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

			// Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if (resultado.next()) {
				novoUsuario.setId(resultado.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar usuário. " + "\nCausa: " + e.getMessage());
		} finally {
			// Fechar a conex�o
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return novoUsuario;
	}

	public boolean atualizar(Usuario usuarioEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE USUARIO " + " SET ID_PESSOA = ?, ID_TIPOUSUARIO = ?, MATRICULA = ?, "
				+ " VALORHORA = ?, EMAIL = ?, LOGIN = ?, SENHA = ?" + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, usuarioEditado.getPessoa().getId());
			query.setInt(2, usuarioEditado.getTipoUsuario().getValor());
			query.setInt(3, usuarioEditado.getMatricula());
			query.setDouble(4, usuarioEditado.getValorHora());
			query.setString(5, usuarioEditado.getEmail());
			query.setString(6, usuarioEditado.getLogin());
			query.setString(7, usuarioEditado.getSenha());
			query.setInt(8, usuarioEditado.getId());
			query.execute();

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar usuario. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return atualizou;
	}

	public Usuario consultarPorId(int id) {
		Usuario usuarioConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM USUARIO " + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				usuarioConsultado = montarUsuarioComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar usuario com id: + " + id + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return usuarioConsultado;
	}

	public Usuario consultarPorLoginSenha(String login, String senha) {
		Usuario usuarioConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM USUARIO " + " WHERE LOGIN = ? AND SENHA = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setString(1, login);
			query.setString(2, senha);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				usuarioConsultado = montarUsuarioComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar usuario com login: + " + login + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return usuarioConsultado;
	}

	private Usuario montarUsuarioComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Usuario usuarioConsultado = new Usuario();
		PessoaDAO pessoa = new PessoaDAO();
		usuarioConsultado.setId(resultado.getInt("id"));
		usuarioConsultado.setPessoa(pessoa.consultarPorId(resultado.getInt("ID_PESSOA")));
		usuarioConsultado.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(resultado.getInt("ID_TIPOUSUARIO")));
		usuarioConsultado.setMatricula(resultado.getInt("MATRICULA"));
		usuarioConsultado.setValorHora(resultado.getDouble("VALORHORA"));
		usuarioConsultado.setEmail(resultado.getString("EMAIL"));
		usuarioConsultado.setLogin(resultado.getString("LOGIN"));
		usuarioConsultado.setSenha(resultado.getString("SENHA"));
		return usuarioConsultado;
	}
	private Usuario montarClienteComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Usuario usuarioConsultado = new Usuario();
		PessoaDAO pessoa = new PessoaDAO();
		usuarioConsultado.setId(resultado.getInt("ID_CLIENTE"));
		usuarioConsultado.setPessoa(pessoa.consultarPorId(resultado.getInt("ID_PESSOA")));
		;
		usuarioConsultado.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(resultado.getInt("ID_TIPOUSUARIO")));
		usuarioConsultado.setMatricula(resultado.getInt("MATRICULA"));
		usuarioConsultado.setValorHora(resultado.getDouble("VALORHORA"));
		usuarioConsultado.setEmail(resultado.getString("EMAIL"));
		usuarioConsultado.setLogin(resultado.getString("LOGIN"));
		usuarioConsultado.setSenha(resultado.getString("SENHA"));
		return usuarioConsultado;
	}
	
	private Usuario montarPessoaComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Usuario usuarioConsultado = new Usuario();
		PessoaDAO pessoa = new PessoaDAO();
		usuarioConsultado.setId(resultado.getInt("id"));
		usuarioConsultado.setPessoa(pessoa.consultarPorId(resultado.getInt("ID_PESSOA")));
		usuarioConsultado.setPessoa(pessoa.consultarPorNome(resultado.getString("PESSOA.NOME")));
		usuarioConsultado.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(resultado.getInt("ID_TIPOUSUARIO")));
		usuarioConsultado.setMatricula(resultado.getInt("MATRICULA"));
		usuarioConsultado.setValorHora(resultado.getDouble("VALORHORA"));
		usuarioConsultado.setEmail(resultado.getString("EMAIL"));
		usuarioConsultado.setLogin(resultado.getString("LOGIN"));
		usuarioConsultado.setSenha(resultado.getString("SENHA"));
		return usuarioConsultado;
	}

	public boolean excluir(int id) {
		boolean excluiu = false;

		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM USUARIO " + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir usuario. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public List<Usuario> consultarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM USUARIO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Usuario usuarioConsultado = montarUsuarioComResultadoDoBanco(resultado);
				usuarios.add(usuarioConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas os usuarios" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return usuarios;
	}

	public List<Usuario> consultarComFiltros(UsuarioSeletor seletor) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * \n"
				+ "FROM\n USUARIO INNER JOIN PESSOA ON USUARIO.ID_PESSOA = PESSOA.ID";

		if (seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}

		if (seletor.temPaginacao()) {
			sql += " LIMIT " + seletor.getLimite() + " OFFSET " + seletor.getOffset();
		}

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			while (resultado.next()) {
				Usuario usuarioBuscado = montarPessoaComResultadoDoBanco(resultado);
				usuarios.add(usuarioBuscado);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os usuarios. \n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return usuarios;
	}

	private String preencherFiltros(String sql, UsuarioSeletor seletor) {
        boolean primeiro = true;
        if(seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
            if(primeiro) {
                    sql += " WHERE ";
                } else {
                    sql += " AND ";
                }
                sql += " PESSOA.NOME LIKE '%" + seletor.getNome() + "%'";
                primeiro = false;
            }
        if(seletor.getTipo() != null) {
        if(primeiro) {
                sql += " WHERE ";
            } else {
                sql += " AND ";
            }
            sql += " ID_TIPOUSUARIO = " + seletor.getTipo().getValor();
            primeiro = false;
        }
        return sql;
    }

	public int contarTotalRegistrosComFiltros(UsuarioSeletor seletor) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from USUARIO INNER JOIN PESSOA ON USUARIO.ID_PESSOA = PESSOA.ID";

		if (seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				total = resultado.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Erro contar o total de usuarios" + "\n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return total;
	}

	public List<Usuario> consultarPorTipoUsuario(Integer tipoUsuario) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM USUARIO WHERE ID_TIPOUSUARIO = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {

			query.setInt(1, tipoUsuario);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Usuario usuarioConsultado = montarUsuarioComResultadoDoBanco(resultado);
				usuarios.add(usuarioConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas os usuarios" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return usuarios;
	}

	public List<Usuario> consultarClientesUsuarioAutenticado(Integer id) {
		List<Usuario> clientes = new ArrayList<Usuario>();
		
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * \n"
				+ "FROM\n"
				+ "	TREINO\n"
				+ "INNER JOIN USUARIO ON\n"
				+ "	TREINO.ID_CLIENTE = USUARIO.ID\n"
				+ "INNER JOIN PESSOA ON\n"
				+ "	USUARIO.ID_PESSOA = PESSOA.ID\n"
				+ "WHERE \n"
				+ "	ID_PROFISSIONAL = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {

			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Usuario usuarioConsultado = montarClienteComResultadoDoBanco(resultado);
				clientes.add(usuarioConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todas os clientes" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return clientes;
	}
}
