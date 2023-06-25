package model.seletor;

public class TreinoSeletor extends BaseSeletor{
	
	private int nivel;

	
	@Override
	public boolean temFiltro() {
		return this.nivel != 0;
	}
	
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
