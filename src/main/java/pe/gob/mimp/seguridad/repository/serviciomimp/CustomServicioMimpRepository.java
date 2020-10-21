/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.serviciomimp;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.seguridad.model.ServicioMimp;

/**
 *
 * @author Omar
 */
public interface CustomServicioMimpRepository {

    List<ServicioMimp> findByParams(Map<String, Object> parameters, String orderBy) throws Exception;

    int getRecordCount(Map<String, Object> parameters) throws Exception;

}
