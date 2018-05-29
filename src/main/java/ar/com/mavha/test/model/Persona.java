package ar.com.mavha.test.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
public class Persona implements Serializable {
	@Id
	@Min(1)
	@Max(100000000)
	private Long dni;
	@NotNull(message = "validation.nombre.notNull")
	@Pattern(regexp = "^[a-z-A-Z\\D]+$",message = "validation.nombre.badFormat")
	@Size(min = 1, message = "validation.nombre.notEmpty")
	private String nombre;
	@NotNull(message = "validation.nombre.notNull")
	@Pattern(regexp = "^[a-z-A-Z\\D]+$",message = "validation.nombre.badFormat")
	@Size(min = 1, message = "validation.nombre.notEmpty")
	private String apellido;
	@NotNull
	@Min(0)
	private Integer edad;
}
