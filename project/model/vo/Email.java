package model.vo;

public class Email {
	
	private String nomeCliente;
	private String emailCliente;
	private String emailPersonal;
	private String treinoCliente; 
	private String prazoInicial;
	private String prazoFinal;
	private String nomePersonal;
	
	public Email() {
		super();
	}
	
	

	public Email(String nomeCliente, String emailCliente, String emailPersonal, String treinoCliente,
			String prazoInicial, String prazoFinal, String nomePersonal) {
		super();
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.emailPersonal = emailPersonal;
		this.treinoCliente = treinoCliente;
		this.prazoInicial = prazoInicial;
		this.prazoFinal = prazoFinal;
		this.nomePersonal = nomePersonal;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getTreinoCliente() {
		return treinoCliente;
	}

	public void setTreinoCliente(String treinoCliente) {
		this.treinoCliente = treinoCliente;
	}

	public String getPrazoInicial() {
		return prazoInicial;
	}

	public void setPrazoInicial(String prazoInicial) {
		this.prazoInicial = prazoInicial;
	}

	public String getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(String prazoFinal) {
		this.prazoFinal = prazoFinal;
	}

	public String getNomePersonal() {
		return nomePersonal;
	}

	public void setNomePersonal(String nomePersonal) {
		this.nomePersonal = nomePersonal;
	}


}
