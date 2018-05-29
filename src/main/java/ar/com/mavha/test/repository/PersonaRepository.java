package ar.com.mavha.test.repository;

import ar.com.mavha.test.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	Optional<Persona> findPersonaByDni(Long dni);
}
