package ar.com.mavha.test;

import ar.com.mavha.test.dto.CreatePersonaRequest;
import ar.com.mavha.test.dto.CreatePersonaResponse;
import org.dummycreator.DummyCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonaEndpointIT  {

	@Autowired
	private TestRestTemplate restTemplate;

	private DummyCreator dummyCreator;

	@Before
	public void init() {
		dummyCreator = new DummyCreator();
	}

	@Test
	public void obtenerListaDePersonas() {
		ResponseEntity<List> personas = restTemplate.getForEntity("/persona", List.class);
		Assert.assertTrue(!personas.getBody().isEmpty());
	}


	@Test
	public void sePuedeCrearPersona() {
		CreatePersonaResponse response = restTemplate.postForObject(String.format("/persona/%d", 1), generatePersonaRequest(), CreatePersonaResponse.class);
		Assert.assertEquals(Long.valueOf(1L), response.getDni());
		Assert.assertTrue(response.getApellido() != null);
		Assert.assertTrue(response.getEdad() != null);
		Assert.assertTrue(response.getNombre() != null);
		Assert.assertTrue(!response.getNombre().isEmpty());
		Assert.assertTrue(!response.getApellido().isEmpty());
		Assert.assertTrue(response.getEdad().intValue()>0);
	}

	@Test
	public void noSePuedeCrearPersonaExistente() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		Long numeroDocumento = dniRandom();
		ResponseEntity<CreatePersonaResponse> response1 = restTemplate.postForEntity(String.format("/persona/%d", numeroDocumento), personaRequest, CreatePersonaResponse.class);
		ResponseEntity<CreatePersonaResponse> response2 = restTemplate.postForEntity(String.format("/persona/%d", numeroDocumento), personaRequest, CreatePersonaResponse.class);
		Assert.assertEquals(200, response1.getStatusCodeValue());
		Assert.assertEquals(409, response2.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConEdadNula() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setEdad(null);
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConEdadMenorA0() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setEdad(-1);
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConNombreNulo() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setNombre(null);
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConNombreVacio() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setNombre("");
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConApellidoNulo() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setApellido(null);
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaConApellidoVacio() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		personaRequest.setApellido("");
		ResponseEntity<List> response1 = restTemplate.postForEntity(String.format("/persona/%d", dniRandom()), personaRequest, List.class);
		Assert.assertEquals(400, response1.getStatusCodeValue());
	}

	@Test
	public void noSePuedeCrearPersonaSinDNI() {
		CreatePersonaRequest personaRequest = generatePersonaRequest();
		ResponseEntity<String> response1 = restTemplate.postForEntity("/persona", personaRequest, String.class);
		Assert.assertEquals(404, response1.getStatusCodeValue());
	}

	private CreatePersonaRequest generatePersonaRequest() {
		CreatePersonaRequest personaRequest = dummyCreator.create(CreatePersonaRequest.class);
		personaRequest.setEdad(edadRandom());
		return personaRequest;
	}

	private Long getRandom(Long min, Long max) {
		return new Random().longs(min, max).findFirst().getAsLong();
	}

	private Integer getRandom(Integer min, Integer max) {
		return new Random().ints(min, max).findFirst().getAsInt();
	}

	private Integer edadRandom() {
		return getRandom(1, 150);
	}

	private Long dniRandom() {
		return getRandom(2l, 99999999l);
	}

}
