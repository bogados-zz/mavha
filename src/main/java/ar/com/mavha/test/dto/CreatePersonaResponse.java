package ar.com.mavha.test.dto;

import lombok.Data;

@Data
public class CreatePersonaResponse {
	private Long dni;
	private String nombre;
	private String apellido;
	private Integer edad;
}
