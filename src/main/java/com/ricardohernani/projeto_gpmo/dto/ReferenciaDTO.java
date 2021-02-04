package com.ricardohernani.projeto_gpmo.dto;

import java.io.Serializable;

import com.ricardohernani.projeto_gpmo.domain.Referencia;

public class ReferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	private Double ponto;
	private Double valor;
	
	public ReferenciaDTO () {
	}
	
	public ReferenciaDTO(Referencia obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		ponto = obj.getPonto();
		valor = obj.getValor();
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPonto() {
		return ponto;
	}

	public void setPonto(Double ponto) {
		this.ponto = ponto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
}
