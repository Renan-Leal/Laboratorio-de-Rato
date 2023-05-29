package model.vo;

public enum NivelTreino {
	BASICO(1), INTERMEDIARIO(2), AVANCADO(3);

	private Integer valor;

	private NivelTreino(Integer valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public static NivelTreino getNivelTreinoPorValor(Integer valor) {
		NivelTreino nivelTreino = null;
		for (NivelTreino elemento : NivelTreino.values()) {
			if (nivelTreino.getValor() == valor) {
				nivelTreino = elemento;
			}
		}
		return nivelTreino;
	}
}
