package pe.gob.mimp.seguridad.repository.salamimp;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.SalaMimp;

public interface SalaMimpRepository extends JpaRepository<SalaMimp, BigDecimal>, CustomSalaMimpRepository{

}
