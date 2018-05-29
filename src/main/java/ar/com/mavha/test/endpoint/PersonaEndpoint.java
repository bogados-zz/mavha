package ar.com.mavha.test.endpoint;

import ar.com.mavha.test.dto.CreatePersonaRequest;
import ar.com.mavha.test.dto.CreatePersonaResponse;
import ar.com.mavha.test.dto.PersonaListDTO;
import io.swagger.annotations.Api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persona")
@Api("Persona API")
@Produces(MediaType.APPLICATION_JSON)
public interface PersonaEndpoint extends BaseEndpoint {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	List<PersonaListDTO> readAllPersonas();

	@POST
	@Path("/{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	CreatePersonaResponse createPersona(@NotNull @PathParam("dni") Long dni, @NotNull @Valid CreatePersonaRequest createPersonaRequest);

}
