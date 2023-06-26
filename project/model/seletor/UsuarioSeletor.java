package model.seletor;

public class UsuarioSeletor extends BaseSeletor{
	
	private String nome;
	private String tipo;

	@Override
	public boolean temFiltro() {
		return (this.nome != null && this.nome.trim().length() > 0) || (this.tipo != null && this.tipo.trim().length() > 0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
