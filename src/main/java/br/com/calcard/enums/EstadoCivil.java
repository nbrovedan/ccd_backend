package br.com.calcard.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCivil {
	SOLTEIRO("Solteiro"),CASADO("Casado"),DIVORCIADO("Divorciado"),UNIAOESTAVEL("União estável"),VIUVO("Viúvo");
	
	private final String opcao;
	
	EstadoCivil(String valorOpcao){
		opcao = valorOpcao;
	}
	
	@JsonValue
	public String getOpcao() {
		return opcao;
	}
}
