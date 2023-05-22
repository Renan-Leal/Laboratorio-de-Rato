package model.vo;

import java.time.LocalDateTime;

public class Pessoa {
	private Integer id;
	private Endereco endereco;
	private String cpf;
	private String nome;
	private String telefone;
	private LocalDateTime dtNascimento;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, Endereco endereco, String cpf, String nome, String telefone, LocalDateTime dtNascimento) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	

	
	
	
	
	

}
