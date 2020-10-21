/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.trabajador;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.seguridad.model.Trabajador;

/**
 *
 * @author Omar
 */
public interface CustomTrabajadorRepository {

    List<Trabajador> findByParams(Map<String, Object> parameters, String orderBy);

    int getRecordCount(Map<String, Object> parameters);

}
