package model.vo;

import java.time.LocalDateTime;

public class Agendamento {
	private Integer id;
	private Usuario cliente;
	private Usuario profissional;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFinal;
	
	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agendamento(Integer id, Usuario cliente, Usuario profissional, LocalDateTime dataHoraInicio,
			LocalDateTime dataHoraFinal) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.profissional = profissional;
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
