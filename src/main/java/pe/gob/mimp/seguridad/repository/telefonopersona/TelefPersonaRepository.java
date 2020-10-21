package pe.gob.mimp.seguridad.repository.telefonopersona;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.TelefonoPersona;


public interface TelefPersonaRepository extends JpaRepository<TelefonoPersona, BigDecimal>, CustomTelefPersonaRepository{

}
