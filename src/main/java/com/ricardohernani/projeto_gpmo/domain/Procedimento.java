package com.ricardohernani.projeto_gpmo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ricardohernani.projeto_gpmo.domain.enums.PremioProcedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.TipoProcedimento;

@Entity
public class Procedimento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer tipo;
	private Integer premio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="referencia_id")
	private Referencia referencia;
	
	
	
	public Procedimento() {
	}

	public Procedimento(Integer id,  TipoProcedimento tipo, PremioProcedimento premio, Paciente paciente,
						Referencia referencia) {
		super();
		this.id = id;
		this.tipo = tipo.getCod();
		this.premio = premio.getCod2();
		this.paciente = paciente;
		this.referencia = referencia;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Referencia getReferencia() {
		return referencia;
	}
	
	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}
	
	//Conferir se não precisa de gerar hash e equals para caracteristica e tipo

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimento other = (Procedimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

		
}
