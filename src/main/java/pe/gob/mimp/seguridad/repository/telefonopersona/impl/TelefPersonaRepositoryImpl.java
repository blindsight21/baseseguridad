/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.telefonopersona.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.Persona;
import pe.gob.mimp.seguridad.model.TelefonoPersona;
import pe.gob.mimp.seguridad.repository.telefonopersona.CustomTelefPersonaRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class TelefPersonaRepositoryImpl implements CustomTelefPersonaRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<TelefonoPersona> obtenerTelefonos(Persona persona) 
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<TelefonoPersona> cq = getEntityManager().getCriteriaBuilder().createQuery(TelefonoPersona.class);
        Root<TelefonoPersona> registro = cq.from(TelefonoPersona.class);
        //TelefonoPersona_.flgActivo
        //TelefonoPersona_.nidPersona
        //TelefonoPersona_.nidTelefonoPersona
        cq.where(
               cb.and(
                       cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                       cb.equal(registro.get("nidPersona"), persona.getNidPersona().toBigInteger())));
        
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get("nidTelefonoPersona")));
       
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
}
