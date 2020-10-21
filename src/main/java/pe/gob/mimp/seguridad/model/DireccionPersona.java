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
@Table(name = "DIRECCION_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionPersona.findAll", query = "SELECT d FROM DireccionPersona d"),
    @NamedQuery(name = "DireccionPersona.findByNidDireccionPersona", query = "SELECT d FROM DireccionPersona d WHERE d.nidDireccionPersona = :nidDireccionPersona"),
    @NamedQuery(name = "DireccionPersona.findByNidDistrito", query = "SELECT d FROM DireccionPersona d WHERE d.nidDistrito = :nidDistrito"),
    @NamedQuery(name = "DireccionPersona.findByNidVia", query = "SELECT d FROM DireccionPersona d WHERE d.nidVia = :nidVia"),
    @NamedQuery(name = "DireccionPersona.findByTxtDireccion", query = "SELECT d FROM DireccionPersona d WHERE d.txtDireccion = :txtDireccion"),
    @NamedQuery(name = "DireccionPersona.findByFlgActivo", query = "SELECT d FROM DireccionPersona d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "DireccionPersona.findByNidUsuario", query = "SELECT d FROM DireccionPersona d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "DireccionPersona.findByTxtPc", query = "SELECT d FROM DireccionPersona d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "DireccionPersona.findByTxtIp", query = "SELECT d FROM DireccionPersona d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "DireccionPersona.findByFecEdicion", query = "SELECT d FROM DireccionPersona d WHERE d.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "DireccionPersona.findByNidLugar", query = "SELECT d FROM DireccionPersona d WHERE d.nidLugar = :nidLugar"),
    @NamedQuery(name = "DireccionPersona.findByTxtLugar", query = "SELECT d FROM DireccionPersona d WHERE d.txtLugar = :txtLugar")})
public class DireccionPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DIRECCION_PERSONA", sequenceName = "SQ_DIRECCION_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION_PERSONA")
    @Column(name = "NID_DIRECCION_PERSONA")
    private BigDecimal nidDireccionPersona;
    @Column(name = "NID_DISTRITO")
    private BigInteger nidDistrito;
    @Column(name = "NID_VIA")
    private BigInteger nidVia;
//    @Size(max = 1024)
    @Column(name = "TXT_DIRECCION")
    private String txtDireccion;
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
    @Column(name = "NID_LUGAR")
    private BigInteger nidLugar;
//    @Size(max = 128)
    @Column(name = "TXT_LUGAR")
    private String txtLugar;
    @JoinColumn(name = "NID_PERSONA", referencedColumnName = "NID_PERSONA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;

    public DireccionPersona() {
    }

    public DireccionPersona(BigDecimal nidDireccionPersona) {
        this.nidDireccionPersona = nidDireccionPersona;
    }

    public BigDecimal getNidDireccionPersona() {
        return nidDireccionPersona;
    }

    public void setNidDireccionPersona(BigDecimal nidDireccionPersona) {
        this.nidDireccionPersona = nidDireccionPersona;
    }

    public BigInteger getNidDistrito() {
        return nidDistrito;
    }

    public void setNidDistrito(BigInteger nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public BigInteger getNidVia() {
        return nidVia;
    }

    public void setNidVia(BigInteger nidVia) {
        this.nidVia = nidVia;
    }

    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
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

    public BigInteger getNidLugar() {
        return nidLugar;
    }

    public void setNidLugar(BigInteger nidLugar) {
        this.nidLugar = nidLugar;
    }

    public String getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(String txtLugar) {
        this.txtLugar = txtLugar;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDireccionPersona != null ? nidDireccionPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPersona)) {
            return false;
        }
        DireccionPersona other = (DireccionPersona) object;
        if ((this.nidDireccionPersona == null && other.nidDireccionPersona != null) || (this.nidDireccionPersona != null && !this.nidDireccionPersona.equals(other.nidDireccionPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.DireccionPersona[ nidDireccionPersona=" + nidDireccionPersona + " ]";
    }
    
}
