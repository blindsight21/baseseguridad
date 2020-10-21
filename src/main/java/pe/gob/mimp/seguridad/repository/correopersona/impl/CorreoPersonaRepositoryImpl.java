/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.correopersona.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.CorreoPersona;
import pe.gob.mimp.seguridad.model.Persona;
import pe.gob.mimp.seguridad.repository.correopersona.CustomCorreoPersonaRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class CorreoPersonaRepositoryImpl implements CustomCorreoPersonaRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<CorreoPersona> obtenerCorreos(Persona persona) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<CorreoPersona> cq = getEntityManager().getCriteriaBuilder().createQuery(CorreoPersona.class);
        Root<CorreoPersona> registro = cq.from(CorreoPersona.class);
//CorreoPersona_.flgActivo
        //CorreoPersona_.nidPersona
        cq.where(
                cb.and(
                        cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                        cb.equal(registro.get("nidPersona"), persona.getNidPersona().toBigInteger())));

        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get("nidCorreoPersona")));
        // CorreoPersona_.nidCorreoPersona)
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

}
