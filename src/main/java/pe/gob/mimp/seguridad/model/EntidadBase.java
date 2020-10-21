package pe.gob.mimp.seguridad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 Ministerio de la Mujer y Poblaciones Vulnerables (Lima -
 * Peru) DIRECCION GENERAL DE FAMILIA Y COMUNIDAD - DIRECCION DE BENEFICENCIA
 * PUBLICAS
 *
 * PROYECTO SISBEN
 *
 * All rights reserved. Used by permission This software is the confidential and
 * proprietary information of MIMP ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with MIMP.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
/**
 * @objetivo: Permite tener los atributos generales para las clases entidades
 * @autor: Ing. Oscar Mateo
 * @fecha: 01/03/2018
 *
 * ------------------------------------------------------------------------
 * Modificaciones Fecha Nombre Descripción
 * ------------------------------------------------------------------------
 *
 */
@MappedSuperclass
public abstract class EntidadBase implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer activo;
    private Long usuarioRegistroId;
    private Date fechaRegistro;
    private Long usuarioEdicionId;
    private Date fechaEdicion;
    private String pc;
    private String direccionIp;

    public abstract Serializable getEntityId();

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Long getUsuarioRegistroId() {
        return usuarioRegistroId;
    }

    public void setUsuarioRegistroId(Long usuarioRegistroId) {
        this.usuarioRegistroId = usuarioRegistroId;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getUsuarioEdicionId() {
        return usuarioEdicionId;
    }

    public void setUsuarioEdicionId(Long usuarioEdicionId) {
        this.usuarioEdicionId = usuarioEdicionId;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

}
