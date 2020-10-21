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
@Table(name = "TIPO_DOCUMENTO_MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentoModulo.findAll", query = "SELECT t FROM TipoDocumentoModulo t"),
    @NamedQuery(name = "TipoDocumentoModulo.findByNidTipoDocumentoModulo", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.nidTipoDocumentoModulo = :nidTipoDocumentoModulo"),
    @NamedQuery(name = "TipoDocumentoModulo.findByFlgActivo", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoDocumentoModulo.findByNidUsuario", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoDocumentoModulo.findByTxtPc", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoDocumentoModulo.findByTxtIp", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoDocumentoModulo.findByFecEdicion", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "TipoDocumentoModulo.findByNidTipoDocumento", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.nidTipoDocumento = :nidTipoDocumento"),
    @NamedQuery(name = "TipoDocumentoModulo.findByNidModulo", query = "SELECT t FROM TipoDocumentoModulo t WHERE t.nidModulo = :nidModulo")})
public class TipoDocumentoModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_DOCUMENTO_MODULO", sequenceName = "SQ_TIPO_DOCUMENTO_MODULO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_DOCUMENTO_MODULO")
    @Column(name = "NID_TIPO_DOCUMENTO_MODULO")
    private BigDecimal nidTipoDocumentoModulo;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "NID_TIPO_DOCUMENTO")
    private BigInteger nidTipoDocumento;
    @Column(name = "NID_MODULO")
    private BigInteger nidModulo;

    public TipoDocumentoModulo() {
    }

    public TipoDocumentoModulo(BigDecimal nidTipoDocumentoModulo) {
        this.nidTipoDocumentoModulo = nidTipoDocumentoModulo;
    }

    public TipoDocumentoModulo(BigDecimal nidTipoDocumentoModulo, BigInteger nidUsuario) {
        this.nidTipoDocumentoModulo = nidTipoDocumentoModulo;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidTipoDocumentoModulo() {
        return nidTipoDocumentoModulo;
    }

    public void setNidTipoDocumentoModulo(BigDecimal nidTipoDocumentoModulo) {
        this.nidTipoDocumentoModulo = nidTipoDocumentoModulo;
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

    public BigInteger getNidTipoDocumento() {
        return nidTipoDocumento;
    }

    public void setNidTipoDocumento(BigInteger nidTipoDocumento) {
        this.nidTipoDocumento = nidTipoDocumento;
    }

    public BigInteger getNidModulo() {
        return nidModulo;
    }

    public void setNidModulo(BigInteger nidModulo) {
        this.nidModulo = nidModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoDocumentoModulo != null ? nidTipoDocumentoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoModulo)) {
            return false;
        }
        TipoDocumentoModulo other = (TipoDocumentoModulo) object;
        if ((this.nidTipoDocumentoModulo == null && other.nidTipoDocumentoModulo != null) || (this.nidTipoDocumentoModulo != null && !this.nidTipoDocumentoModulo.equals(other.nidTipoDocumentoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.TipoDocumentoModulo[ nidTipoDocumentoModulo=" + nidTipoDocumentoModulo + " ]";
    }
    
}
