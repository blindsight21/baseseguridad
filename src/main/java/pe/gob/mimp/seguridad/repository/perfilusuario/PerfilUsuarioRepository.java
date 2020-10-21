package pe.gob.mimp.seguridad.repository.perfilusuario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.PerfilUsuario;


public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, BigDecimal>, CustomPerfilUsuarioRepository{

}
