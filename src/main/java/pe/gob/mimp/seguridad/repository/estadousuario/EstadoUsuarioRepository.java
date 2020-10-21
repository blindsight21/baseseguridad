package pe.gob.mimp.seguridad.repository.estadousuario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.EstadoUsuario;

public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, BigDecimal>, CustomEstadoUsuarioRepository{

}
