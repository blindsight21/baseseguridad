/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.usuariobeneficencia;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.seguridad.model.UsuarioBeneficencia;

/**
 *
 * @author Omar
 */
public interface CustomUsuarioBenRepository {

    List<UsuarioBeneficencia> findByParams(Map<String, Object> parameters, String orderBy);

    int getRecordCount(Map<String, Object> parameters);

}
