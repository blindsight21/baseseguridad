/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.salamimp;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.seguridad.model.SalaMimp;

/**
 *
 * @author Omar
 */
public interface CustomSalaMimpRepository {

    List<SalaMimp> findByParams(Map<String, Object> parameters, String orderBy) throws Exception;

    int getRecordCount(Map<String, Object> parameters) throws Exception;

}
