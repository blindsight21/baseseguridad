package pe.gob.mimp.seguridad.repository.usuario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, BigDecimal>, CustomUsuarioRepository{

}
