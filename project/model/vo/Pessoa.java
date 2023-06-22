package model.vo;

import java.time.LocalDate;

public class Pessoa {
	private Integer id;
	private Endereco endereco;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dtNascimento;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, Endereco endereco, String nome, String cpf, String telefone, LocalDate dtNascimento) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
		this.cpf = cpf;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



}
