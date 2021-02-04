package com.ricardohernani.projeto_gpmo.dto;

import java.io.Serializable;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.domain.Referencia;
import com.ricardohernani.projeto_gpmo.domain.enums.PremioProcedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.TipoProcedimento;

public class ProcedimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private Integer tipo;
	private Integer premio;
	
	private Referencia referencias;
	
	private Paciente pacientes;
		
	public ProcedimentoDTO() {
	}

	public ProcedimentoDTO (Procedimento obj) {
		id = obj.getId();
		tipo = obj.getTipo().getCod();
		premio = obj.getPremio().getCod2();
		referencias = obj.getReferencia();
		pacientes = obj.getPaciente();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoProcedimento getTipo() {
		return TipoProcedimento.toEnum(tipo);
	}

	public void setTipo(TipoProcedimento tipo) {
		this.tipo = tipo.getCod();
	}

	public PremioProcedimento getPremio() {
		return PremioProcedimento.toEnum(premio);
	}

	public void setPremio(PremioProcedimento premio) {
		this.premio = premio.getCod2();
	}

	public Referencia getReferencias() {
		return referencias;
	}

	public void setReferencias(Referencia referencias) {
		this.referencias = referencias;
	}

	public Paciente getPacientes() {
		return pacientes;
	}

	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}

	
}


