package com.ricardohernani.projeto_gpmo.dto;

import java.io.Serializable;
import java.util.Date;

public class PacienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer registro;
	private Date data;
	
	private Integer tipo;
	private Integer premio;
	
	private Integer codigo;
	
	
	
	
	PacienteNewDTO() {
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


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Integer getPremio() {
		return premio;
	}


	public void setPremio(Integer premio) {
		this.premio = premio;
	}


	
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
