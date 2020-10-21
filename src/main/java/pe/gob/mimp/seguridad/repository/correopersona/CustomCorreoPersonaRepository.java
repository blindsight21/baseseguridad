/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.correopersona;

import java.util.List;
import pe.gob.mimp.seguridad.model.CorreoPersona;
import pe.gob.mimp.seguridad.model.Persona;

/**
 *
 * @author Omar
 */
public interface CustomCorreoPersonaRepository {

    List<CorreoPersona> obtenerCorreos(Persona persona)  throws Exception;
}
