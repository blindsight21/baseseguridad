package pe.gob.mimp.seguridad.repository.cargo;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.mimp.seguridad.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, BigDecimal>, CustomCargoRepository{

}
