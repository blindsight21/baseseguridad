package pe.gob.mimp.seguridad.repository.correopersona;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.CorreoPersona;



public interface CorreoPersonaRepository extends JpaRepository<CorreoPersona, BigDecimal>, CustomCorreoPersonaRepository{

}
