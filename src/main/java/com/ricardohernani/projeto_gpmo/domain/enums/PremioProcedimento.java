package com.ricardohernani.projeto_gpmo.domain.enums;

public enum PremioProcedimento {

	DINHEIRO(1, "Valor em dinheiro"),
	TAREFA_BASICA(2, "Tarefa básica");
	
	private int cod2;
	private String descricao2;
	
	private PremioProcedimento(int cod2, String descricao2) {
		this.cod2 = cod2;
		this.descricao2 = descricao2;
	}

	public int getCod2() {
		return cod2;
	}

	public String getDescricao2() {
		return descricao2;
	}
	
	public static PremioProcedimento toEnum(Integer cod2) {
		
		if (cod2 == null) {
			return null;
		}
		
		for (PremioProcedimento x: PremioProcedimento.values()) {
			if (cod2.equals(x.getCod2())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod2);
	}
	
}
	

