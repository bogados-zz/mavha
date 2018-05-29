package ar.com.mavha.test.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Persona implements Serializable {
	@Id
	@Min(1)
	@Max(100000000)
	private Long dni;
	@NotNull
	@NotEmpty
	private String nombre;
	@NotNull
	@NotEmpty
	private String apellido;
	@NotNull
	@Min(0)
	private Integer edad;
}
