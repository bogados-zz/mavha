package ar.com.mavha.test.service;

import ar.com.mavha.test.model.Persona;

import java.util.List;

public interface PersonaService {

	List<Persona> readAllPersonas();

	Persona crearPersona(Persona persona);

}
