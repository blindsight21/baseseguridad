package pe.gob.mimp.seguridad.repository.area;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Area;

public interface AreaRepository extends JpaRepository<Area, BigDecimal>, CustomAreaRepository {

}
