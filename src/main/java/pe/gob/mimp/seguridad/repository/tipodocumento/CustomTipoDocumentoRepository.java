/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.tipodocumento;

import pe.gob.mimp.seguridad.model.TipoDocumento;

/**
 *
 * @author Omar
 */
public interface CustomTipoDocumentoRepository {

    TipoDocumento obtener(String nombre) throws Exception;
}
