/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.perfil;

import java.util.List;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.model.Usuario;

/**
 *
 * @author Omar
 */
public interface CustomPerfilRepository {

    List<Perfil>  obtenerPerfiles(Usuario usuario, Modulo modulo) throws Exception;
    
    List<Perfil> obtenerPerfilesDelModulo(Modulo modulo) throws Exception;
}
