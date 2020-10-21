package pe.gob.mimp.seguridad.repository.funcionalidadperfil;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.FuncionalidadPerfil;


public interface FuncPerfilRepository extends JpaRepository<FuncionalidadPerfil, BigDecimal>, CustomFuncPerfilRepository{

}
