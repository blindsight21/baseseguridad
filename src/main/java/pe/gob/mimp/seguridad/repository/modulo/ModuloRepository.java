package pe.gob.mimp.seguridad.repository.modulo;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Modulo;


public interface ModuloRepository extends JpaRepository<Modulo, BigDecimal>, CustomModuloRepository{

}
