package br.com.calcard.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResultadoAvaliacao {
	APROVADO("Aprovado"), NEGADO("Negado");
	
	private final String opcao;
	
	private ResultadoAvaliacao(String valorOpcao) {
		opcao = valorOpcao;
	}
	
	@JsonValue
	public String getOpcao() {
		return opcao;
	}
}
