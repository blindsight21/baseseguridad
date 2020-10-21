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
@Table(name = "TIPO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersona.findAll", query = "SELECT t FROM TipoPersona t"),
    @NamedQuery(name = "TipoPersona.findByNidTipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.nidTipoPersona = :nidTipoPersona"),
    @NamedQuery(name = "TipoPersona.findByTxtTipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.txtTipoPersona = :txtTipoPersona"),
    @NamedQuery(name = "TipoPersona.findByFlgActivo", query = "SELECT t FROM TipoPersona t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoPersona.findByNidUsuario", query = "SELECT t FROM TipoPersona t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoPersona.findByTxtPc", query = "SELECT t FROM TipoPersona t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoPersona.findByTxtIp", query = "SELECT t FROM TipoPersona t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoPersona.findByFecEdicion", query = "SELECT t FROM TipoPersona t WHERE t.fecEdicion = :fecEdicion")})
public class TipoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_PERSONA", sequenceName = "SQ_TIPO_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_PERSONA")
    @Column(name = "NID_TIPO_PERSONA")
    private BigDecimal nidTipoPersona;
//    @Size(max = 50)
    @Column(name = "TXT_TIPO_PERSONA")
    private String txtTipoPersona;
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
    @OneToMany(mappedBy = "tipoPersona", fetch = FetchType.LAZY)
    private List<Persona> personaList;

    public TipoPersona() {
    }

    public TipoPersona(BigDecimal nidTipoPersona) {
        this.nidTipoPersona = nidTipoPersona;
    }

    public BigDecimal getNidTipoPersona() {
        return nidTipoPersona;
    }

    public void setNidTipoPersona(BigDecimal nidTipoPersona) {
        this.nidTipoPersona = nidTipoPersona;
    }

    public String getTxtTipoPersona() {
        return txtTipoPersona;
    }

    public void setTxtTipoPersona(String txtTipoPersona) {
        this.txtTipoPersona = txtTipoPersona;
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
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoPersona != null ? nidTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.nidTipoPersona == null && other.nidTipoPersona != null) || (this.nidTipoPersona != null && !this.nidTipoPersona.equals(other.nidTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.TipoPersona[ nidTipoPersona=" + nidTipoPersona + " ]";
    }
    
}
