package com.ricardohernani.projeto_gpmo.domain;

import java.io.Serializable;

public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	private Double ponto;
	private Double valor;
	
	
	public Referencia() {
	}


	public Referencia(Integer codigo, String descricao, Double ponto, Double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.ponto = ponto;
		this.valor = valor;
	}


	//Avaliar retirada dos setters, pois estes não devem ser alterados pelo usuário.
	
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

	//criei apenas so hash e equals para código e descricao, pois apenas estes serão comparados 
	//pelo conteúdo
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Referencia other = (Referencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	
}
