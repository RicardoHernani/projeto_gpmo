package com.ricardohernani.projeto_gpmo.dto;

/*Classe PacienteDTO serve para filtrar quais dados mostrar. No caso: id, registro, data
 e lista de procedimentos. Colocar nesta classe apenas o que é para se mostrar. 
 Não é necessario alterar a Classe Paciente nem a PacienteResource.
 No postman a busca vai mostrar tudo inclusive os procedimentos. Se quiser mostrar id e registro
 é só excluir data e procedimentos do construtor e dos getters e setters*/

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.ricardohernani.projeto_gpmo.domain.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	@NotNull (message="Não pode ser nulo")
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
