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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "CORREO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorreoPersona.findAll", query = "SELECT c FROM CorreoPersona c"),
    @NamedQuery(name = "CorreoPersona.findByNidCorreoPersona", query = "SELECT c FROM CorreoPersona c WHERE c.nidCorreoPersona = :nidCorreoPersona"),
    @NamedQuery(name = "CorreoPersona.findByTxtCorreoPersona", query = "SELECT c FROM CorreoPersona c WHERE c.txtCorreoPersona = :txtCorreoPersona"),
    @NamedQuery(name = "CorreoPersona.findByNidPersona", query = "SELECT c FROM CorreoPersona c WHERE c.nidPersona = :nidPersona"),
    @NamedQuery(name = "CorreoPersona.findByFlgActivo", query = "SELECT c FROM CorreoPersona c WHERE c.flgActivo = :flgActivo"),
    @NamedQuery(name = "CorreoPersona.findByNidUsuario", query = "SELECT c FROM CorreoPersona c WHERE c.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "CorreoPersona.findByTxtPc", query = "SELECT c FROM CorreoPersona c WHERE c.txtPc = :txtPc"),
    @NamedQuery(name = "CorreoPersona.findByTxtIp", query = "SELECT c FROM CorreoPersona c WHERE c.txtIp = :txtIp"),
    @NamedQuery(name = "CorreoPersona.findByFecEdicion", query = "SELECT c FROM CorreoPersona c WHERE c.fecEdicion = :fecEdicion")})
public class CorreoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_CORREO_PERSONA", sequenceName = "SQ_CORREO_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CORREO_PERSONA")
    @Column(name = "NID_CORREO_PERSONA")
    private BigDecimal nidCorreoPersona;
//    @Size(max = 50)
    @Column(name = "TXT_CORREO_PERSONA")
    private String txtCorreoPersona;
    @Column(name = "NID_PERSONA")
    private BigInteger nidPersona;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
//    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;

    public CorreoPersona() {
    }

    public CorreoPersona(BigDecimal nidCorreoPersona) {
        this.nidCorreoPersona = nidCorreoPersona;
    }

    public BigDecimal getNidCorreoPersona() {
        return nidCorreoPersona;
    }

    public void setNidCorreoPersona(BigDecimal nidCorreoPersona) {
        this.nidCorreoPersona = nidCorreoPersona;
    }

    public String getTxtCorreoPersona() {
        return txtCorreoPersona;
    }

    public void setTxtCorreoPersona(String txtCorreoPersona) {
        this.txtCorreoPersona = txtCorreoPersona;
    }

    public BigInteger getNidPersona() {
        return nidPersona;
    }

    public void setNidPersona(BigInteger nidPersona) {
        this.nidPersona = nidPersona;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidCorreoPersona != null ? nidCorreoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorreoPersona)) {
            return false;
        }
        CorreoPersona other = (CorreoPersona) object;
        if ((this.nidCorreoPersona == null && other.nidCorreoPersona != null) || (this.nidCorreoPersona != null && !this.nidCorreoPersona.equals(other.nidCorreoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.CorreoPersona[ nidCorreoPersona=" + nidCorreoPersona + " ]";
    }
    
}
