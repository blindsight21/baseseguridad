/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.area;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.seguridad.model.Area;

/**
 *
 * @author Omar
 */
public interface CustomAreaRepository {

    List<Area> findByParams(Map<String, Object> parameters, String orderBy) throws Exception;

    public int getRecordCount(Map<String, Object> parameters) throws Exception;

    List<Area> findAllByField(Object field, Object value);
}
