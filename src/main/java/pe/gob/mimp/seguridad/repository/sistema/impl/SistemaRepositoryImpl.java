/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.sistema.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.seguridad.repository.sistema.CustomSistemaRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class SistemaRepositoryImpl implements CustomSistemaRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
