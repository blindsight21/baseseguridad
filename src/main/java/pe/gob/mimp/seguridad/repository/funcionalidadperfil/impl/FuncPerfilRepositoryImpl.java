/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.funcionalidadperfil.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.seguridad.repository.funcionalidadperfil.CustomFuncPerfilRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class FuncPerfilRepositoryImpl implements CustomFuncPerfilRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
