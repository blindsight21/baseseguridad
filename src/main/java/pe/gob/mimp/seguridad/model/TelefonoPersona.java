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
@Table(name = "TELEFONO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoPersona.findAll", query = "SELECT t FROM TelefonoPersona t"),
    @NamedQuery(name = "TelefonoPersona.findByNidTelefonoPersona", query = "SELECT t FROM TelefonoPersona t WHERE t.nidTelefonoPersona = :nidTelefonoPersona"),
    @NamedQuery(name = "TelefonoPersona.findByTxtTelefonoPersona", query = "SELECT t FROM TelefonoPersona t WHERE t.txtTelefonoPersona = :txtTelefonoPersona"),
    @NamedQuery(name = "TelefonoPersona.findByNidPersona", query = "SELECT t FROM TelefonoPersona t WHERE t.nidPersona = :nidPersona"),
    @NamedQuery(name = "TelefonoPersona.findByFlgActivo", query = "SELECT t FROM TelefonoPersona t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TelefonoPersona.findByNidUsuario", query = "SELECT t FROM TelefonoPersona t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TelefonoPersona.findByTxtPc", query = "SELECT t FROM TelefonoPersona t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TelefonoPersona.findByTxtIp", query = "SELECT t FROM TelefonoPersona t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TelefonoPersona.findByFecEdicion", query = "SELECT t FROM TelefonoPersona t WHERE t.fecEdicion = :fecEdicion")})
public class TelefonoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TELEFONO_PERSONA", sequenceName = "SQ_TELEFONO_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONO_PERSONA")
    @Column(name = "NID_TELEFONO_PERSONA")
    private BigDecimal nidTelefonoPersona;
//    @Size(max = 20)
    @Column(name = "TXT_TELEFONO_PERSONA")
    private String txtTelefonoPersona;
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
    @JoinColumn(name = "NID_TIPO_TELEFONO", referencedColumnName = "NID_TIPO_TELEFONO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTelefono tipoTelefono;

    public TelefonoPersona() {
    }

    public TelefonoPersona(BigDecimal nidTelefonoPersona) {
        this.nidTelefonoPersona = nidTelefonoPersona;
    }

    public BigDecimal getNidTelefonoPersona() {
        return nidTelefonoPersona;
    }

    public void setNidTelefonoPersona(BigDecimal nidTelefonoPersona) {
        this.nidTelefonoPersona = nidTelefonoPersona;
    }

    public String getTxtTelefonoPersona() {
        return txtTelefonoPersona;
    }

    public void setTxtTelefonoPersona(String txtTelefonoPersona) {
        this.txtTelefonoPersona = txtTelefonoPersona;
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

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTelefonoPersona != null ? nidTelefonoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPersona)) {
            return false;
        }
        TelefonoPersona other = (TelefonoPersona) object;
        if ((this.nidTelefonoPersona == null && other.nidTelefonoPersona != null) || (this.nidTelefonoPersona != null && !this.nidTelefonoPersona.equals(other.nidTelefonoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.TelefonoPersona[ nidTelefonoPersona=" + nidTelefonoPersona + " ]";
    }
    
}
