package ar.com.mavha.test.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreatePersonaRequest {
	@NotNull(message = "validation.nombre.notNull")
	@NotEmpty(message = "validation.nombre.notEmpty")
	private String nombre;
	@NotNull(message = "validation.apellido.notNull")
	@NotEmpty(message = "validation.apellido.notEmpty")
	private String apellido;
	@NotNull(message = "validation.edad.notNull")
	@Min(value = 0, message = "validation.edad.lowerThan")
	private Integer edad;
}
