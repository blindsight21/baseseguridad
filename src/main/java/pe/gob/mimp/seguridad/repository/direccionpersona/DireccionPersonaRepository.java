package pe.gob.mimp.seguridad.repository.direccionpersona;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.DireccionPersona;

public interface DireccionPersonaRepository extends JpaRepository<DireccionPersona, BigDecimal>, CustomDireccionPersonaRepository{

}
