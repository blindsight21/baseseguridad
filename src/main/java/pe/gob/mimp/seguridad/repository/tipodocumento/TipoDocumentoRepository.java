package pe.gob.mimp.seguridad.repository.tipodocumento;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.mimp.seguridad.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, BigDecimal>, CustomTipoDocumentoRepository{

}
