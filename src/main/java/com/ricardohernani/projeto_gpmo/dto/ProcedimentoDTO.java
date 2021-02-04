package com.ricardohernani.projeto_gpmo.dto;

import java.io.Serializable;

import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.domain.Referencia;

public class ProcedimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private Integer tipo;
	private Integer premio;
	
	
	
	private Referencia referencias;
		
	public ProcedimentoDTO() {
	}

	public ProcedimentoDTO(Procedimento obj) {
		id = obj.getId();
		tipo = obj.getTipo().getCod();
		premio = obj.getPremio().getCod2();
		referencias = obj.getReferencia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Referencia getReferencias() {
		return referencias;
	}

	public void setReferencias(Referencia referencias) {
		this.referencias = referencias;
	}

	
	

}


