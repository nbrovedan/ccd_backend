package br.com.calcard.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Faixas {
	RENDABAIXA("Renda baixa"),
	REPROVADO("Reprovado pela política de crédito"),
	FAIXA1("Entre 100,00 e 500,00 reais"),
	FAIXA2("Entre 500,00 e 1.000,00 reais"),
	FAIXA3("Entre 1.000,00 e 1.500,00 reais"),
	FAIXA4("Entre 1.500,00 e 2.000,00 reais"),
	FAIXA5("Superior a 2.000,00 reais");
	
	private final String texto;
	
	private Faixas(String opcaoTexto) {
		texto = opcaoTexto;
	}
	
	@JsonValue
	public String getTexto() {
		return texto;
	}
}
