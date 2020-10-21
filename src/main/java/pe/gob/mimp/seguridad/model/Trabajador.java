/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "TRABAJADOR")
public class Trabajador implements Serializable {
    @JoinColumn(name = "NID_AREA", referencedColumnName = "NID_AREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area nidArea;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TRABAJADOR", sequenceName = "SQ_TRABAJADOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRABAJADOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_TRABAJADOR")
    private BigDecimal nidTrabajador;
//    @Size(max = 64)
    @Column(name = "TXT_APELLIDO_PATERNO")
    private String txtApellidoPaterno;
//    @Size(max = 64)
    @Column(name = "TXT_APELLIDO_MATERNO")
    private String txtApellidoMaterno;
//    @Size(max = 64)
    @Column(name = "TXT_NOMBRE")
    private String txtNombre;
    @Column(name = "NID_REGIMEN_LABORAL")
    private BigInteger nidRegimenLaboral;
    @Column(name = "NID_CARGO")
    private BigInteger nidCargo;
    @Column(name = "NID_TIPO_DOCUMENTO")
    private BigInteger nidTipoDocumento;
//    @Size(max = 32)
    @Column(name = "TXT_NUMERO_DOCUMENTO")
    private String txtNumeroDocumento;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
//    @Size(max = 20)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @Column(name = "FLG_TRABAJADOR_TERCERO")
    private BigInteger flgTrabajadorTercero;

    public Trabajador() {
    }

    public Trabajador(BigDecimal nidTrabajador) {
        this.nidTrabajador = nidTrabajador;
    }

    public BigDecimal getNidTrabajador() {
        return nidTrabajador;
    }

    public void setNidTrabajador(BigDecimal nidTrabajador) {
        this.nidTrabajador = nidTrabajador;
    }

    public String getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(String txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public String getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(String txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public BigInteger getNidRegimenLaboral() {
        return nidRegimenLaboral;
    }

    public void setNidRegimenLaboral(BigInteger nidRegimenLaboral) {
        this.nidRegimenLaboral = nidRegimenLaboral;
    }

    public BigInteger getNidCargo() {
        return nidCargo;
    }

    public void setNidCargo(BigInteger nidCargo) {
        this.nidCargo = nidCargo;
    }

    public BigInteger getNidTipoDocumento() {
        return nidTipoDocumento;
    }

    public void setNidTipoDocumento(BigInteger nidTipoDocumento) {
        this.nidTipoDocumento = nidTipoDocumento;
    }

    public String getTxtNumeroDocumento() {
        return txtNumeroDocumento;
    }

    public void setTxtNumeroDocumento(String txtNumeroDocumento) {
        this.txtNumeroDocumento = txtNumeroDocumento;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }
    
    public BigInteger getFlgTrabajadorTercero() {
        return flgTrabajadorTercero;
    }

    public void setFlgTrabajadorTercero(BigInteger flgTrabajadorTercero) {
        this.flgTrabajadorTercero = flgTrabajadorTercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTrabajador != null ? nidTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.nidTrabajador == null && other.nidTrabajador != null) || (this.nidTrabajador != null && !this.nidTrabajador.equals(other.nidTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Trabajador[ nidTrabajador=" + nidTrabajador + " ]";
    }

    public Area getNidArea() {
        return nidArea;
    }

    public void setNidArea(Area nidArea) {
        this.nidArea = nidArea;
    }
    
}
