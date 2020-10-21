/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.funcionalidad.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.Funcionalidad;
import pe.gob.mimp.seguridad.model.FuncionalidadPerfil;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.repository.funcionalidad.CustomFuncionalidadRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class FuncionalidadRepositoryImpl implements CustomFuncionalidadRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Funcionalidad> obtenerPaginas(Perfil perfil) {

        CriteriaQuery<Funcionalidad> cq = getEntityManager().getCriteriaBuilder().createQuery(Funcionalidad.class);
        Root<Funcionalidad> registro = cq.from(Funcionalidad.class);
        // Funcionalidad_.funcionalidadPerfilList
        Join<Funcionalidad, FuncionalidadPerfil> joinFuncionalidadPerfil = registro.join("funcionalidadPerfilList");
        //Funcionalidad_.flgActivo
        //FuncionalidadPerfil_.perfil
        cq.distinct(true);
        cq.select(registro)
                .where(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE)
                        ,getEntityManager().getCriteriaBuilder().equal(joinFuncionalidadPerfil.get("perfil"), perfil)
                );
//Funcionalidad_.numOrden
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get("numOrden")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
}
