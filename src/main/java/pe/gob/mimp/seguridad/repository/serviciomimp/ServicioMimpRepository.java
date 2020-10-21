package pe.gob.mimp.seguridad.repository.serviciomimp;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.ServicioMimp;

public interface ServicioMimpRepository extends JpaRepository<ServicioMimp, BigDecimal>, CustomServicioMimpRepository{

}
