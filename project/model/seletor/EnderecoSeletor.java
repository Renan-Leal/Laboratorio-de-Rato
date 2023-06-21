package model.seletor;

public class EnderecoSeletor extends BaseSeletor{
	
	private String bairro;
	private String cidade;

	
	@Override
	public boolean temFiltro() {
		return (this.bairro != null && this.bairro.trim().length() > 0);
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
}


