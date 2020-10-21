package pe.gob.mimp.seguridad.repository.tipodocumentomodulo;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.seguridad.model.TipoDocumentoModulo;

public interface TipoDocuModRepository extends JpaRepository<TipoDocumentoModulo, BigDecimal>, CustomTipoDocuModRepository{

}
