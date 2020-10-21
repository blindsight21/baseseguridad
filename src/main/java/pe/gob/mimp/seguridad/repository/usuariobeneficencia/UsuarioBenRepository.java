package pe.gob.mimp.seguridad.repository.usuariobeneficencia;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.UsuarioBeneficencia;

public interface UsuarioBenRepository extends JpaRepository<UsuarioBeneficencia, BigDecimal>, CustomUsuarioBenRepository {

}
