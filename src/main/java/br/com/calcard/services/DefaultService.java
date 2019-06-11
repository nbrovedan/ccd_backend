package br.com.calcard.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DefaultService {
	
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class NotFoundException extends IllegalArgumentException{
		public NotFoundException(Integer codigo) {
			super(String.format("Registro código %d não foi encontrado!", codigo));
		}
	}
}
