/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.direccionpersona.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.DireccionPersona;
import pe.gob.mimp.seguridad.model.Persona;
import pe.gob.mimp.seguridad.repository.direccionpersona.CustomDireccionPersonaRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class DireccionPersonaRepositoryImpl implements CustomDireccionPersonaRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<DireccionPersona> obtenerDirecciones(Persona persona)
    {
        CriteriaQuery<DireccionPersona> cq = getEntityManager().getCriteriaBuilder().createQuery(DireccionPersona.class);
        Root<DireccionPersona> registro = cq.from(DireccionPersona.class);
        
        cq.distinct(true);
        //DireccionPersona_.flgActivo
        //DireccionPersona_.persona
        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE)
                        ,getEntityManager().getCriteriaBuilder().equal(registro.get("persona"), persona)
                ));
        //DireccionPersona_.fecEdicion
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get("fecEdicion")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
}
