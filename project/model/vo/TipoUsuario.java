package model.vo;

public enum TipoUsuario {
	ADMINISTRADOR(1), PERSONAL_TRAINER(2), CLIENTE(3);

	private Integer valor;

	private TipoUsuario(Integer valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public static TipoUsuario getTipoUsuarioPorValor(Integer valor) {
		TipoUsuario tipoUsuario = null;
		for (TipoUsuario elemento : TipoUsuario.values()) {
			if (elemento.getValor() == valor) {
				tipoUsuario = elemento;
			}
		}
		return tipoUsuario;
	}
}
