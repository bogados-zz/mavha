package ar.com.mavha.test.exception;

import org.springframework.http.HttpStatus;

public class PersonaExistException extends BusinessException {

	public PersonaExistException(Long dni) {
		super("1001", "persona.exist.exception.message",null, "persona.exist.exception.description", new String[]{dni.toString()}, HttpStatus.CONFLICT);
	}

}
