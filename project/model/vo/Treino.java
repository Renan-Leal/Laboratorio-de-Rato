package model.vo;

public class Treino {
	private Integer id;
	private Usuario cliente;
	private String A;
	private String B;
	private String C;
	private String D;
	private String E;
	
	
	public Treino() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Treino(Integer id, Usuario cliente, String a, String b, String c, String d, String e) {
		super();
		this.id = id;
		this.cliente = cliente;
		A = a;
		B = b;
		C = c;
		D = d;
		E = e;
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


	public String getA() {
		return A;
	}


	public void setA(String a) {
		A = a;
	}


	public String getB() {
		return B;
	}


	public void setB(String b) {
		B = b;
	}


	public String getC() {
		return C;
	}


	public void setC(String c) {
		C = c;
	}


	public String getD() {
		return D;
	}


	public void setD(String d) {
		D = d;
	}


	public String getE() {
		return E;
	}


	public void setE(String e) {
		E = e;
	}
	
	
	
	

}
