package pe.gob.mimp.seguridad.repository.tipotelefono;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.TipoTelefono;

public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, BigDecimal>, CustomTipoTelefonoRepository{

}
