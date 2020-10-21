package pe.gob.mimp.seguridad.repository.trabajador;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, BigDecimal>, CustomTrabajadorRepository{

}
