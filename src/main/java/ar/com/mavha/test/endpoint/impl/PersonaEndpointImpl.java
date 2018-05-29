package ar.com.mavha.test.endpoint.impl;

import ar.com.mavha.test.dto.CreatePersonaRequest;
import ar.com.mavha.test.dto.CreatePersonaResponse;
import ar.com.mavha.test.dto.PersonaListDTO;
import ar.com.mavha.test.endpoint.PersonaEndpoint;
import ar.com.mavha.test.model.Persona;
import ar.com.mavha.test.service.PersonaService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class PersonaEndpointImpl implements PersonaEndpoint {

	@Autowired
	private PersonaService personaService;
	@Autowired
	private MapperFacade orikaMapper;

	@Override
	public List<PersonaListDTO> readAllPersonas() {
		return orikaMapper.mapAsList(personaService.readAllPersonas(), PersonaListDTO.class);
	}

	@Override
	public CreatePersonaResponse createPersona(@NotNull Long dni, @NotNull @Valid CreatePersonaRequest createPersonaRequest) {
		Persona persona = orikaMapper.map(createPersonaRequest, Persona.class);
		persona.setDni(dni);
		return orikaMapper.map(personaService.crearPersona(persona), CreatePersonaResponse.class);
	}

}
