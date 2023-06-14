package model.vo;

public class Email {
	
	private String nomeUsuario;
	private String emailUsuario;
	private String treino;
	
	public Email() {
		super();
	}

	public Email(String nomeUsuario, String emailUsuario, String treino) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.treino = treino;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getTreino() {
		return treino;
	}

	public void setTreino(String treino) {
		this.treino = treino;
	}

	
	
	
	
	
	
	

}
