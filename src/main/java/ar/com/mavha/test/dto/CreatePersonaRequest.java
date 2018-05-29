package ar.com.mavha.test.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreatePersonaRequest {
	@NotNull(message = "validation.nombre.notNull")
	@Pattern(regexp = "^[a-z-A-Z\\D]+$",message = "validation.nombre.badFormat")
	@Size(min = 1, message = "validation.nombre.notEmpty")
	private String nombre;
	@NotNull(message = "validation.apellido.notNull")
	@Pattern(regexp = "^[a-z-A-Z\\D]+$",message = "validation.apellido.badFormat")
	@Size(min = 1, message = "validation.apellido.notEmpty")
	//@NotEmpty(message = "validation.apellido.notEmpty")
	private String apellido;
	@NotNull(message = "validation.edad.notNull")
	@Min(value = 0, message = "validation.edad.lowerThan")
	private Integer edad;
}
