/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.repository.usuario.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import pe.gob.mimp.seguridad.model.Funcionalidad;
import pe.gob.mimp.seguridad.model.FuncionalidadPerfil;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.model.PerfilUsuario;
import pe.gob.mimp.seguridad.model.Usuario;
import pe.gob.mimp.seguridad.repository.usuario.CustomUsuarioRepository;
import pe.gob.mimp.seguridad.util.Constantes;

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
public class UsuarioRepositoryImpl implements CustomUsuarioRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Usuario> validar(String usuario, String password, Modulo modulo) {
//		logger.info(":: UsuarioFacade.validar :: Starting execution ...");

        CriteriaQuery<Usuario> cq = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);

        Root<Usuario> registro = cq.from(Usuario.class);
        Join<Usuario, PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        Join<PerfilUsuario, Perfil> joinPerfil = joinPerfilUsuario.join("perfil");

        cq.distinct(true);

//		logger.info("flgActivo:"+BigInteger.ONE+"; usuario:"+usuario+"; password:"+password+"; modulo:"+modulo);
        cq.where(getEntityManager().getCriteriaBuilder().and(
                getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE),
                getEntityManager().getCriteriaBuilder().equal(registro.get("txtUsuario"), usuario),
                getEntityManager().getCriteriaBuilder().equal(registro.get("txtPassword"), password),
                 getEntityManager().getCriteriaBuilder().equal(joinPerfil.get("modulo"), modulo)));

        /*String hsql = "select u from Usuario u ";
		    hsql = "        left join fetch u.persona p ";
		    hsql = "where u.flgActivo = "+BigInteger.ONE+" and ";
		    hsql = "      u.txtUsuario = '"+usuario+"' and ";
		    hsql = "      u.txtPassword = '"+password+"' and ";
		logger.info("  hsql="+hsql);*/
        javax.persistence.Query q = getEntityManager().createQuery(cq); // hsql

//		logger.info(":: UsuarioFacade.validar :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public List<Usuario> getEntidadesModulo(Modulo modulo) {
        CriteriaQuery<Usuario> cq = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);

        Root<Usuario> registro = cq.from(Usuario.class);
        // Usuario_.perfilUsuarioList
        // PerfilUsuario_.perfil
        // Usuario_.flgActivo
        // Perfil_.modulo
        Join<Usuario, PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        Join<PerfilUsuario, Perfil> joinPerfil = joinPerfilUsuario.join("perfil");

        cq.distinct(true);

        cq.where(getEntityManager().getCriteriaBuilder().and(
                getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE),
                getEntityManager().getCriteriaBuilder().equal(joinPerfil.get("modulo"), modulo)));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public List<Usuario> getEntidadesModuloTodos(Modulo modulo) {
        CriteriaQuery<Usuario> cq = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);

        Root<Usuario> registro = cq.from(Usuario.class);

        // Usuario_.perfilUsuarioList
        // PerfilUsuario_.perfil
        Join<Usuario, PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        Join<PerfilUsuario, Perfil> joinPerfil = joinPerfilUsuario.join("perfil");

        cq.distinct(true);

        // Perfil_.modulo
        cq.where(getEntityManager().getCriteriaBuilder()
                .and(getEntityManager().getCriteriaBuilder().equal(joinPerfil.get("modulo"), modulo)));

        // Usuario_.txtUsuario
        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("txtUsuario")));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public List<Funcionalidad> obtenerFuncionalidades(Usuario usuario, Modulo modulo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Funcionalidad> cq = getEntityManager().getCriteriaBuilder().createQuery(Funcionalidad.class);
        Root<Funcionalidad> registro = cq.from(Funcionalidad.class);
        // Funcionalidad_.funcionalidadPerfilList
        // FuncionalidadPerfil_.perfil
        // Perfil_.perfilUsuarioList
        Join<Funcionalidad, FuncionalidadPerfil> joinFuncionalidadPerfil = registro.join("funcionalidadPerfilList");
        Join<FuncionalidadPerfil, Perfil> joinPerfil = joinFuncionalidadPerfil.join("perfil");
        Join<Perfil, PerfilUsuario> joinPerfilUsuario = joinPerfil.join("perfilUsuarioList");

        // Funcionalidad_.flgActivo
        // Perfil_.flgActivo
        // FuncionalidadPerfil_.flgActivo
        // Perfil_.modulo
        // PerfilUsuario_.usuario
        // Funcionalidad_.numOrden
        cq.where(cb.and(cb.equal(registro.get("flgActivo"), BigInteger.ONE),
                cb.equal(joinPerfil.get("flgActivo"), BigInteger.ONE),
                cb.equal(joinFuncionalidadPerfil.get("flgActivo"), BigInteger.ONE),
                cb.equal(joinPerfil.get("modulo"), modulo), cb.equal(joinPerfilUsuario.get("usuario"), usuario)));

        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("numOrden")));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public List<Usuario> getEntidadesModuloPerfil(Modulo modulo, Perfil perfil) {

        CriteriaQuery<Usuario> cq = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);

        Root<Usuario> registro = cq.from(Usuario.class);
        // Usuario_.perfilUsuarioList
        // PerfilUsuario_.perfil
        // PerfilUsuario_.perfil
        // Perfil_.modulo
        Join<Usuario, PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        Join<PerfilUsuario, Perfil> joinModulo = joinPerfilUsuario.join("perfil");

        cq.distinct(true);

        cq.where(getEntityManager().getCriteriaBuilder().and(
                getEntityManager().getCriteriaBuilder().equal(joinPerfilUsuario.join("perfil"), perfil),
                getEntityManager().getCriteriaBuilder().equal(joinModulo.get("modulo"), modulo)));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public Usuario obtenerUsuarioPorModulo(Modulo modulo, String nombreUsuario) {
        Usuario usuario = null;

        CriteriaQuery<Usuario> cq = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);
        Root<Usuario> registro = cq.from(Usuario.class);
        // Usuario_.perfilUsuarioList
        // PerfilUsuario_.perfil
        // Usuario_.txtUsuario
        // Perfil_.modulo
        Join<Usuario, PerfilUsuario> joinPerfilUsuario = registro.join("perfilUsuarioList");
        Join<PerfilUsuario, Perfil> joinModulo = joinPerfilUsuario.join("perfil");

        cq.distinct(true);

        cq.where(getEntityManager().getCriteriaBuilder().and(
                getEntityManager().getCriteriaBuilder().equal(registro.join("txtUsuario"), nombreUsuario),
                getEntityManager().getCriteriaBuilder().equal(joinModulo.get("modulo"), modulo)));

        javax.persistence.Query q = getEntityManager().createQuery(cq);

        usuario = (Usuario) q.getSingleResult();

        return usuario;
    }
    
    @Override
    public List<Usuario> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Usuario> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Usuario.class);
        Root<Usuario> entitie = criteriaQuery.from(Usuario.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}
