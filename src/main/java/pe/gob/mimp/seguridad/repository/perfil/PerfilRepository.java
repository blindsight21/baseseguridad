package pe.gob.mimp.seguridad.repository.perfil;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.Perfil;


public interface PerfilRepository extends JpaRepository<Perfil, BigDecimal>, CustomPerfilRepository{

}
