package com.ricardohernani.projeto_gpmo.domain.enums;

public enum TipoProcedimento {

	PRINCIPAL(1, "Procedimento principal"),
	SECUNDARIO(2, "Procedimento secundário");
	
	private int cod;
	private String descricao;
	
	private TipoProcedimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoProcedimento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoProcedimento x: TipoProcedimento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
