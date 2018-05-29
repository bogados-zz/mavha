package ar.com.mavha.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomError {
	private String code;
	private String message;
	private String description;
}
