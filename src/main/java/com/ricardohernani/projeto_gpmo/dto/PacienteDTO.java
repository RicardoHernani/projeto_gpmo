package com.ricardohernani.projeto_gpmo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ricardohernani.projeto_gpmo.domain.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer registro;
	private Date data;
	
	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		registro = obj.getRegistro();
		data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	

}
