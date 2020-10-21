/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.parametroseguridad;

import java.util.List;
import pe.gob.mimp.seguridad.model.ParametroSeguridad;

/**
 *
 * @author Omar
 */
public interface CustomParamSeguridadRepository {

    List<ParametroSeguridad> findAllByField(Object field, Object value);
    
}
