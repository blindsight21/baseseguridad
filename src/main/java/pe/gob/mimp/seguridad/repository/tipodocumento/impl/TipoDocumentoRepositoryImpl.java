/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.tipodocumento.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.TipoDocumento;
import pe.gob.mimp.seguridad.repository.tipodocumento.CustomTipoDocumentoRepository;
import pe.gob.mimp.seguridad.util.Constantes;

/**
 *
 * @author Omar
 */
public class TipoDocumentoRepositoryImpl implements CustomTipoDocumentoRepository {

    @PersistenceContext(unitName=Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public TipoDocumento obtener(String nombre) throws Exception {
        TipoDocumento tipoDocumento = null;

        CriteriaQuery<TipoDocumento> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoDocumento.class);
        Root<TipoDocumento> registro = cq.from(TipoDocumento.class);

        cq.distinct(true);
        //TipoDocumento_.txtDescripcion
        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("txtDescripcion"), nombre)
                ));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        List<TipoDocumento> lista = q.getResultList();

        if (null != lista && 0 < lista.size()) {
            tipoDocumento = lista.get(0);
        }

        return tipoDocumento;
    }
}
