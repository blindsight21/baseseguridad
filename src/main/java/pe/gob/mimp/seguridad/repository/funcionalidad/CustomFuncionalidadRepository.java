/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.funcionalidad;

import java.util.List;
import pe.gob.mimp.seguridad.model.Funcionalidad;
import pe.gob.mimp.seguridad.model.Perfil;

/**
 *
 * @author Omar
 */
public interface CustomFuncionalidadRepository {

   List<Funcionalidad> obtenerPaginas(Perfil perfil) throws Exception;
}
