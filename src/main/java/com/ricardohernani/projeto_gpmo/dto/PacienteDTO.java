package com.ricardohernani.projeto_gpmo.dto;

/*Classe PacienteDTO serve para filtrar quais dados mostrar. No caso: id, registro, data e lista de procedimentos.
 Colocar nesta classe apenas o que é para se mostrar. Não é necessario alterar a Classe Paciente nem a PacienteResource*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer registro;
	private Date data;
	
	private List<Procedimento> procedimentos = new ArrayList<>();
		
	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		registro = obj.getRegistro();
		data = obj.getData();
		procedimentos = obj.getProcedimentos();
	
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
	
	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}


	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

}
