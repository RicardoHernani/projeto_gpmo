package com.ricardohernani.projeto_gpmo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Procedimento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id												//Verificar se nâo precisa colocar @data
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Boolean tipo;
	private Boolean caracteristica;
	
	//Não é necessario criar uma lista aqui?????
	
	public Procedimento() {
	}

	public Procedimento(Integer id, Date data, Boolean tipo, Boolean caracteristica) {
		super();
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.caracteristica = caracteristica;
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

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	public Boolean getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Boolean caracteristica) {
		this.caracteristica = caracteristica;
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
