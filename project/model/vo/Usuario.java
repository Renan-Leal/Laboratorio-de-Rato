package model.vo;

import java.time.LocalDateTime;

public class Usuario {
	private Integer id;
	private Pessoa pessoa;
	private TipoUsuario tipoUsuario;
	private Integer matricula;
	private String email;
	private String login;
	private String senha;
	private Double valorHora;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataExpiracao;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, Pessoa pessoa, TipoUsuario tipoUsuario, Integer matricula, String email, String login,
			String senha, Double valorHora, LocalDateTime dataCadastro, LocalDateTime dataExpiracao) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.tipoUsuario = tipoUsuario;
		this.matricula = matricula;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.valorHora = valorHora;
		this.dataCadastro = dataCadastro;
		this.dataExpiracao = dataExpiracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(LocalDateTime dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	@Override
	public String toString() {
		return pessoa.getNome();
	}

}
