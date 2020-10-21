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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "TIPO_TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTelefono.findAll", query = "SELECT t FROM TipoTelefono t"),
    @NamedQuery(name = "TipoTelefono.findByNidTipoTelefono", query = "SELECT t FROM TipoTelefono t WHERE t.nidTipoTelefono = :nidTipoTelefono"),
    @NamedQuery(name = "TipoTelefono.findByTxtTipoTelefono", query = "SELECT t FROM TipoTelefono t WHERE t.txtTipoTelefono = :txtTipoTelefono"),
    @NamedQuery(name = "TipoTelefono.findByFlgActivo", query = "SELECT t FROM TipoTelefono t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoTelefono.findByNidUsuario", query = "SELECT t FROM TipoTelefono t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoTelefono.findByTxtPc", query = "SELECT t FROM TipoTelefono t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoTelefono.findByTxtIp", query = "SELECT t FROM TipoTelefono t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoTelefono.findByFecEdicion", query = "SELECT t FROM TipoTelefono t WHERE t.fecEdicion = :fecEdicion")})
public class TipoTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_TELEFONO", sequenceName = "SQ_TIPO_TELEFONO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_TELEFONO")
    @Column(name = "NID_TIPO_TELEFONO")
    private BigDecimal nidTipoTelefono;
//    @Size(max = 20)
    @Column(name = "TXT_TIPO_TELEFONO")
    private String txtTipoTelefono;
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
    @OneToMany(mappedBy = "tipoTelefono", fetch = FetchType.LAZY)
    private List<TelefonoPersona> telefonoPersonaList;

    public TipoTelefono() {
    }

    public TipoTelefono(BigDecimal nidTipoTelefono) {
        this.nidTipoTelefono = nidTipoTelefono;
    }

    public BigDecimal getNidTipoTelefono() {
        return nidTipoTelefono;
    }

    public void setNidTipoTelefono(BigDecimal nidTipoTelefono) {
        this.nidTipoTelefono = nidTipoTelefono;
    }

    public String getTxtTipoTelefono() {
        return txtTipoTelefono;
    }

    public void setTxtTipoTelefono(String txtTipoTelefono) {
        this.txtTipoTelefono = txtTipoTelefono;
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

    @XmlTransient
    public List<TelefonoPersona> getTelefonoPersonaList() {
        return telefonoPersonaList;
    }

    public void setTelefonoPersonaList(List<TelefonoPersona> telefonoPersonaList) {
        this.telefonoPersonaList = telefonoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoTelefono != null ? nidTipoTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTelefono)) {
            return false;
        }
        TipoTelefono other = (TipoTelefono) object;
        if ((this.nidTipoTelefono == null && other.nidTipoTelefono != null) || (this.nidTipoTelefono != null && !this.nidTipoTelefono.equals(other.nidTipoTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.TipoTelefono[ nidTipoTelefono=" + nidTipoTelefono + " ]";
    }
    
}
