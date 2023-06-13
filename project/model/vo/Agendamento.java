package model.vo;

import java.time.LocalDateTime;

public class Agendamento {
	private Integer id; //auto increment
	private Usuario cliente; //usuario autenticado
	private Usuario profissional; //inormado pelo cb
	private boolean aceito; // inicia nulo
	// trocar para Boolean(pois pode ser true, fqalse ou null), camel case tb
	private String motivo_rejeicao; //inicia nulo
	private LocalDateTime dataHoraInicio; // info pelo usuario
	private LocalDateTime dataHoraFinal; // se a hr final for maior que a hr max de trabalho do profissional, lança ecessao
	//na listagem de agendamentos do profissional informando um periodo, ter aceite e rejeição
	//fazer listagem de usuario pelo tipo
	
	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agendamento(Integer id, Usuario cliente, Usuario profissional, boolean aceito, String motivo_rejeicao,
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.profissional = profissional;
		this.aceito = aceito;
		this.motivo_rejeicao = motivo_rejeicao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFinal = dataHoraFinal;
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

	public Usuario getProfissional() {
		return profissional;
	}

	public void setProfissional(Usuario profissional) {
		this.profissional = profissional;
	}

	public boolean isAceito() {
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}

	public String getMotivo_rejeicao() {
		return motivo_rejeicao;
	}

	public void setMotivo_rejeicao(String motivo_rejeicao) {
		this.motivo_rejeicao = motivo_rejeicao;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(LocalDateTime dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}
	
	
	
	
	
	

}
