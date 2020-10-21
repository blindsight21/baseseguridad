/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.perfilusuario.impl;

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
import pe.gob.mimp.seguridad.util.Constantes;
import pe.gob.mimp.seguridad.repository.perfilusuario.CustomPerfilUsuarioRepository;

/**
 *
 * @author Omar
 */
public class PerfilUsuarioRepositoryImpl implements CustomPerfilUsuarioRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<PerfilUsuario> obtenerPerfilUsuarioPorModulo(Usuario usuario, Modulo modulo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<PerfilUsuario> cq = getEntityManager().getCriteriaBuilder().createQuery(PerfilUsuario.class);
        Root<PerfilUsuario> registro = cq.from(PerfilUsuario.class);

        //PerfilUsuario_.perfil
        //PerfilUsuario_.flgActivo
        //PerfilUsuario_.usuario
        //Perfil_.modulo
        //PerfilUsuario_.fecModificacion
        Join<PerfilUsuario,Perfil> joinPerfil = registro.join("perfil");

        cq.where(
                cb.and(
                        cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                        cb.equal(registro.get("usuario"), usuario),
                        cb.equal(joinPerfil.get("modulo"), modulo)));

        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("fecModificacion")));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
}
