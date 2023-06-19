package model.vo;

import java.time.LocalDateTime;

public class Treino {
	private Integer id;
	private Usuario cliente;
	private Usuario profissional;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtTermino;
	private NivelTreino nivelTreino;
	private String treino;

	public Treino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Treino(Integer id, Usuario cliente, Usuario profissional, LocalDateTime dtCadastro, LocalDateTime dtTermino,
			NivelTreino nivelTreino, String treino) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.profissional = profissional;
		this.dtCadastro = dtCadastro;
		this.dtTermino = dtTermino;
		this.nivelTreino = nivelTreino;
		this.treino = treino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getProfissional() {
		return profissional;
	}

	public void setProfissional(Usuario profissional) {
		this.profissional = profissional;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public LocalDateTime getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(LocalDateTime dtTermino) {
		this.dtTermino = dtTermino;
	}

	public NivelTreino getNivelTreino() {
		return nivelTreino;
	}

	public void setNivelTreino(NivelTreino nivelTreino) {
		this.nivelTreino = nivelTreino;
	}

	public String getTreino() {
		return treino;
	}

	public void setTreino(String treino) {
		this.treino = treino;
	}

}