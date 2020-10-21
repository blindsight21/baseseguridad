package pe.gob.mimp.seguridad.repository.persona;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, BigDecimal>, CustomPersonaRepository{

}
