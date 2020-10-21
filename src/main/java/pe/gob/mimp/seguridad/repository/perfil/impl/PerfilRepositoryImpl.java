/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.perfil.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.model.PerfilUsuario;
import pe.gob.mimp.seguridad.model.Usuario;
import pe.gob.mimp.seguridad.repository.perfil.CustomPerfilRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class PerfilRepositoryImpl implements CustomPerfilRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Perfil>  obtenerPerfiles(Usuario usuario, Modulo modulo) 
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<Perfil> cq = getEntityManager().getCriteriaBuilder().createQuery(Perfil.class);
        Root<Perfil> registro = cq.from(Perfil.class);
        //Perfil_.perfilUsuarioList
        Join<Perfil,PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        //Perfil_.flgActivo
        //Perfil_.modulo
        //PerfilUsuario_.usuario
        //Perfil_.txtPerfil
        cq.where(
               cb.and(
                       cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                       cb.equal(registro.get("modulo"), modulo),
                       cb.equal(joinPerfilUsuario.get("usuario"), usuario)));
        
        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("txtPerfil")));
       
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
    
    @Override
    public List<Perfil> obtenerPerfilesDelModulo(Modulo modulo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Perfil> cq = getEntityManager().getCriteriaBuilder().createQuery(Perfil.class);
        Root<Perfil> registro = cq.from(Perfil.class);

        //Perfil_.flgActivo
        //Perfil_.modulo
        //Perfil_.txtPerfil
        cq.where(
                cb.and(
                        cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                        cb.equal(registro.get("modulo"), modulo)
                ));

        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("txtPerfil")));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
}
