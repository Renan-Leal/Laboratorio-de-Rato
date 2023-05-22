package model.vo;

public class Treino {
	private Integer id;
	private Usuario cliente;
	private String treino;
	
	public Treino() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Treino(Integer id, Usuario cliente, String treino) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.treino = treino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public String getTreino() {
		return treino;
	}

	public void setTreino(String treino) {
		this.treino = treino;
	}
	
	

	
	
	
	
	
	
	

}
