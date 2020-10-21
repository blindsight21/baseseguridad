package pe.gob.mimp.seguridad.repository.funcionalidad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Funcionalidad;

public interface FuncionalidadRepository extends JpaRepository<Funcionalidad, BigDecimal>, CustomFuncionalidadRepository{

}
