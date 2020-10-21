/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
 * @objetivo: Clase Entidad UsuarioBeneficencia que permite la relación entre Usuario 
 *             y Beneficencia
 * @autor: Ing. Oscar Mateo
 * @fecha: 01/03/2018
 *
 * ------------------------------------------------------------------------
 * Modificaciones Fecha Nombre Descripción
 * ------------------------------------------------------------------------
 *
 */
@Entity
@Table(name = "USUARIO_BENEFI")
public class UsuarioBeneficencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_USUARIO_BENEFI", sequenceName = "SQ_USUARIO_BENEFI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO_BENEFI")
    @Column(name = "NID_USUA_BENE")
    private Long usuarioBeneficenciaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    private Usuario usuario;

    @Column(name = "NID_BENEFICENCIA")
    private Long beneficenciaId;

    @Column(name = "FLG_ACTIVO")
    private Integer activo;

    @Column(name = "NID_USUARIO_REG")
    private Long usuarioRegistroId;

    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "NID_USUA_EDICION")
    private Long usuarioEdicionId;

    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicion;

    @Column(name = "TXT_PC")
    private String pc;

    @Column(name = "TXT_IP")
    private String direccionIp;

    @Transient
    private String nombreSociedadBeneficencia;

    public Long getUsuarioBeneficenciaId() {
        return usuarioBeneficenciaId;
    }

    public void setUsuarioBeneficenciaId(Long usuarioBeneficenciaId) {
        this.usuarioBeneficenciaId = usuarioBeneficenciaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getBeneficenciaId() {
        return beneficenciaId;
    }

    public void setBeneficenciaId(Long beneficenciaId) {
        this.beneficenciaId = beneficenciaId;
    }

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

    public String getNombreSociedadBeneficencia() {
        return nombreSociedadBeneficencia;
    }

    public void setNombreSociedadBeneficencia(String nombreSociedadBeneficencia) {
        this.nombreSociedadBeneficencia = nombreSociedadBeneficencia;
    }

}
