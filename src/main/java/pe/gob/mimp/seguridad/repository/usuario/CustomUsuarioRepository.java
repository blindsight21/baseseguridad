/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.usuario;

import java.util.List;
import pe.gob.mimp.seguridad.model.Funcionalidad;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.model.Usuario;

/**
 *
 * @author Omar
 */
public interface CustomUsuarioRepository {

    List<Usuario> validar(String usuario, String password, Modulo modulo);

    List<Usuario> getEntidadesModulo(Modulo modulo);

    List<Usuario> getEntidadesModuloTodos(Modulo modulo);

    List<Funcionalidad> obtenerFuncionalidades(Usuario usuario, Modulo modulo);

    List<Usuario> getEntidadesModuloPerfil(Modulo modulo, Perfil perfil);

    Usuario obtenerUsuarioPorModulo(Modulo modulo, String nombreUsuario);
    
    List<Usuario> findAllByField(Object field, Object value);

}
