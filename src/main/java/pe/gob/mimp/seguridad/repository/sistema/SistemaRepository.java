package pe.gob.mimp.seguridad.repository.sistema;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Sistema;

public interface SistemaRepository extends JpaRepository<Sistema, BigDecimal>, CustomSistemaRepository{

}
