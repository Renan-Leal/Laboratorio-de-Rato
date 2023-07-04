package model.seletor;

public class EnderecoSeletor extends BaseSeletor{
	
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;

	
	@Override
	public boolean temFiltro() {
		return (this.bairro != null && this.bairro.trim().length() > 0) ||
				(this.cidade != null && this.cidade.trim().length() > 0) ||
				(this.cep != null && this.cep.trim().length() > 0) ||
				(this.estado != null && this.estado.trim().length() > 0);
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}


