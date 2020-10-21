/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.tipopersona;

import java.util.List;
import pe.gob.mimp.seguridad.model.TipoPersona;

/**
 *
 * @author Omar
 */
public interface CustomTipoPersonaRepository {

    List<TipoPersona> findAllByField(Object field, Object value);
    
}
