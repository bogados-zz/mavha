package ar.com.mavha.test.service.impl;

import ar.com.mavha.test.exception.PersonaExistException;
import ar.com.mavha.test.model.Persona;
import ar.com.mavha.test.repository.PersonaRepository;
import ar.com.mavha.test.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	private static final Logger LOG = LoggerFactory.getLogger(PersonaServiceImpl.class);

	@Override
	public List<Persona> readAllPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public Persona crearPersona(Persona persona) {
		Optional<Persona> optPersona = personaRepository.findPersonaByDni(persona.getDni());
		if(optPersona.isPresent()) {
			LOG.error(String.format("Error al intentar crear la persona. La persona tiene el dni %s y ya existe en la base de datos", persona.getDni().toString()));
			throw new PersonaExistException(persona.getDni());
		}
		return personaRepository.save(persona);
	}
}
