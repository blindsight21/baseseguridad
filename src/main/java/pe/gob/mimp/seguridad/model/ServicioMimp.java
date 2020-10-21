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
@Table(name = "SERVICIO_MIMP")
public class ServicioMimp implements Serializable {
//    @Size(max = 2)
    @Column(name = "NUM_PISO")
    private String numPiso;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_SERVICIO_MIMP", sequenceName = "SQ_SERVICIO_MIMP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SERVICIO_MIMP")
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_SERVICIO_MIMP")
    private BigDecimal nidServicioMimp;
    @Column(name = "TXT_SERVICIO_MIMP")
    private String txtServicioMimp;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Column(name = "TXT_PC")
    private String txtPc;
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @JoinColumn(name = "NID_AREA", referencedColumnName = "NID_AREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area nidArea;

    public ServicioMimp() {
    }

    public ServicioMimp(BigDecimal nidServicioMimp) {
        this.nidServicioMimp = nidServicioMimp;
    }

    public BigDecimal getNidServicioMimp() {
        return nidServicioMimp;
    }

    public void setNidServicioMimp(BigDecimal nidServicioMimp) {
        this.nidServicioMimp = nidServicioMimp;
    }

    public String getTxtServicioMimp() {
        return txtServicioMimp;
    }

    public void setTxtServicioMimp(String txtServicioMimp) {
        this.txtServicioMimp = txtServicioMimp;
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

    public Area getNidArea() {
        return nidArea;
    }

    public void setNidArea(Area nidArea) {
        this.nidArea = nidArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidServicioMimp != null ? nidServicioMimp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioMimp)) {
            return false;
        }
        ServicioMimp other = (ServicioMimp) object;
        if ((this.nidServicioMimp == null && other.nidServicioMimp != null) || (this.nidServicioMimp != null && !this.nidServicioMimp.equals(other.nidServicioMimp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.ServicioMimp[ nidServicioMimp=" + nidServicioMimp + " ]";
    }

    public String getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(String numPiso) {
        this.numPiso = numPiso;
    }
    
}
