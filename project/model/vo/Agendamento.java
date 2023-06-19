package model.vo;

import java.time.LocalDateTime;

public class Agendamento {
	private Integer id; //auto increment
	private Usuario cliente; //usuario autenticado
	private Usuario profissional; //inormado pelo cb
	private Boolean aceito; // inicia nulo	
	private String motivoRejeicao; //inicia nulo
	private LocalDateTime dataHoraInicio; // info pelo usuario
	private LocalDateTime dataHoraFinal; // se a hr final for maior que a hr max de trabalho do profissional, lan�a ecessao
	//na listagem de agendamentos do profissional informando um periodo, ter aceite e rejei��o
	//fazer listagem de usuario pelo tipo
	
	public Agendamento(Integer id, Usuario cliente, Usuario profissional, Boolean aceito, String motivoRejeicao,
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.profissional = profissional;
		this.aceito = aceito;
		this.motivoRejeicao = motivoRejeicao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFinal = dataHoraFinal;
	}

	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
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

	public Boolean getAceito() {
		return aceito;
	}

	public void setAceito(Boolean aceito) {
		this.aceito = aceito;
	}

	public String getMotivoRejeicao() {
		return motivoRejeicao;
	}

	public void setMotivoRejeicao(String motivoRejeicao) {
		this.motivoRejeicao = motivoRejeicao;
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
