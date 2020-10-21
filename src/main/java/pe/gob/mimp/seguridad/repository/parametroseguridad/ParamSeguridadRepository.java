package pe.gob.mimp.seguridad.repository.parametroseguridad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.ParametroSeguridad;


public interface ParamSeguridadRepository extends JpaRepository<ParametroSeguridad, BigDecimal>, CustomParamSeguridadRepository{

}
