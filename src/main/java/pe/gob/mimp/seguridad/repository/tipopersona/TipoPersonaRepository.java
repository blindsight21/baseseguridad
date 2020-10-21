package pe.gob.mimp.seguridad.repository.tipopersona;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.TipoPersona;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, BigDecimal>, CustomTipoPersonaRepository{

}
