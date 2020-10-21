/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.usuariobeneficencia.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.EstadoUsuario;
import pe.gob.mimp.seguridad.model.UsuarioBeneficencia;
import pe.gob.mimp.seguridad.repository.usuariobeneficencia.CustomUsuarioBenRepository;
import pe.gob.mimp.seguridad.util.Constantes;
import pe.gob.mimp.seguridad.util.CoreConstant;
import pe.gob.mimp.seguridad.util.Funciones;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 Ministerio de la Mujer y Poblaciones Vulnerables (Lima -
 * Peru) DIRECCION GENERAL DE FAMILIA Y COMUNIDAD DIRECCION DE BENEFICENCIA
 * PUBLICAS PROYECTO SISBEN
 *
 * All rights reserved. Used by permission This software is the confidential and
 * proprietary information of MIMP ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with MIMP.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
/**
 * @objetivo: Clase que implementa los metodos de negocio Usuario / Beneficencia
 * @autor: Ing. Oscar Mateo
 * @fecha: 01/03/2018
 *
 * ------------------------------------------------------------------------
 * Modificaciones Fecha Nombre Descripción
 * ------------------------------------------------------------------------
 *
 */
public class UsuarioBenRepositoryImpl implements CustomUsuarioBenRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UsuarioBeneficencia> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: UsuarioBeneficenciaFacade.findByParams :: Starting execution...");

        String selectClause = "select ub " + buildSelectClause();
        String whereClause = buildWhereClause(parameters);
        if (!Funciones.esVacio(whereClause)) {
            whereClause = " where " + whereClause;
        }

        String orderClause = buildOrderByClause(orderBy);
        if (!Funciones.esVacio(orderClause)) {
            orderClause = " order by " + orderClause;
        }
        String hql = selectClause + whereClause + orderClause;

//        logger.info("   Usuario Beneficencia HQL: " + hql);
        Query q = getEntityManager().createQuery(hql);
        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            q.setParameter(map.getKey(), map.getValue());
        }
//        logger.info(":: UsuarioBeneficenciaFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: UsuarioBeneficenciaFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(ub.usuarioBeneficenciaId) " + buildSelectClause();
        selectClause = selectClause.replaceAll("fetch ", CoreConstant.BLANCO);
        String whereClause = buildWhereClause(parameters);
        if (!Funciones.esVacio(whereClause)) {
            whereClause = " where " + whereClause;
        }

        String hql = selectClause + whereClause;

//        logger.info("getRecordCount HQL: " + hql);
        Query q = getEntityManager().createQuery(hql);

        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            q.setParameter(map.getKey(), map.getValue());
        }
//        logger.info(":: UsuarioBeneficenciaFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from UsuarioBeneficencia ub "
                + " left join fetch ub.usuario u ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("usuarioBeneficenciaId") != null) {
            whereClause = whereClause + "ub.usuarioBeneficenciaId = :usuarioBeneficenciaId";
        }
        if (parameters.get("usuarioId") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "u.nidUsuario = :usuarioId";
        }
        if (parameters.get("usuarioRegistroId") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ub.usuarioRegistroId = :usuarioRegistroId";
        }
        if (parameters.get("activo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ub.activo = :activo";
        }

        return whereClause;
    }

    private String buildOrderByClause(String orderBy) {
        if (Funciones.esVacio(orderBy)) {
            return null;
        }

        String orderByClause = "";
        String[] orderByArray = orderBy.split(CoreConstant.SEPARATOR_COMA);
        for (String orderByElement : orderByArray) {
            if ("usuarioBeneficenciaId".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ub.usuarioBeneficenciaId";
            }
            if ("fechaRegistro".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ub.fechaRegistro desc";
            }
        }

        return orderByClause;
    }

}
