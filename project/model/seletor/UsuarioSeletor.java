package model.seletor;

import model.vo.TipoUsuario;

public class UsuarioSeletor extends BaseSeletor{
	
	private TipoUsuario tipo;
	private String nome;

	@Override
	public boolean temFiltro() {
		return (this.nome != null && this.nome.trim().length() > 0) || (this.tipo != null) ;
	}
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
