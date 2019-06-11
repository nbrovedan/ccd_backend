package br.com.calcard.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {
	MASCULINO("M"), FEMININO("F"), OUTROS("O");
	
	private final String opcao;
	
	Sexo(String valorOpcao) {
		opcao = valorOpcao;
	}

	@JsonValue
	public String getOpcao() {
		return opcao;
	}
}
