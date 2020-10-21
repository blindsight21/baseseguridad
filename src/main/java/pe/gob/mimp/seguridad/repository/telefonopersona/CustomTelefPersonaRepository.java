/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.telefonopersona;

import java.util.List;
import pe.gob.mimp.seguridad.model.Persona;
import pe.gob.mimp.seguridad.model.TelefonoPersona;

/**
 *
 * @author Omar
 */
public interface CustomTelefPersonaRepository {

    List<TelefonoPersona> obtenerTelefonos(Persona persona)  throws Exception;
}
