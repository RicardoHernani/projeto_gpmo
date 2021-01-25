package com.ricardohernani.projeto_gpmo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ricardohernani.projeto_gpmo.domain.enums.PremioProcedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.TipoProcedimento;

@Entity
public class Procedimento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Integer tipo;
	private Integer premio;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="referencia_id")
	private Referencia referencia;
	
	
	
	public Procedimento() {
	}

	public Procedimento(Integer id, Date data, TipoProcedimento tipo, PremioProcedimento premio, Paciente paciente,
						Referencia referencia) {
		super();
		this.id = id;
		this.data = data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
