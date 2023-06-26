package model.seletor;

public class UsuarioSeletor extends BaseSeletor{
	
	private int tipo;

	@Override
	public boolean temFiltro() {
		return this.tipo != 0 ;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
