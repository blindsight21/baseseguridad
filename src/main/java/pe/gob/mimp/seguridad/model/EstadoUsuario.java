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
@Table(name = "ESTADO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuario.findAll", query = "SELECT e FROM EstadoUsuario e"),
    @NamedQuery(name = "EstadoUsuario.findByNidEstadoUsuario", query = "SELECT e FROM EstadoUsuario e WHERE e.nidEstadoUsuario = :nidEstadoUsuario"),
    @NamedQuery(name = "EstadoUsuario.findByTxtEstadoUsuario", query = "SELECT e FROM EstadoUsuario e WHERE e.txtEstadoUsuario = :txtEstadoUsuario"),
    @NamedQuery(name = "EstadoUsuario.findByFlgActivo", query = "SELECT e FROM EstadoUsuario e WHERE e.flgActivo = :flgActivo"),
    @NamedQuery(name = "EstadoUsuario.findByNidUsuario", query = "SELECT e FROM EstadoUsuario e WHERE e.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "EstadoUsuario.findByTxtPc", query = "SELECT e FROM EstadoUsuario e WHERE e.txtPc = :txtPc"),
    @NamedQuery(name = "EstadoUsuario.findByTxtIp", query = "SELECT e FROM EstadoUsuario e WHERE e.txtIp = :txtIp"),
    @NamedQuery(name = "EstadoUsuario.findByFecEdicion", query = "SELECT e FROM EstadoUsuario e WHERE e.fecEdicion = :fecEdicion")})
public class EstadoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ESTADO_USUARIO", sequenceName = "SQ_ESTADO_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO_USUARIO")
    @Column(name = "NID_ESTADO_USUARIO")
    private BigDecimal nidEstadoUsuario;
//    @Size(max = 50)
    @Column(name = "TXT_ESTADO_USUARIO")
    private String txtEstadoUsuario;
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

    public EstadoUsuario() {
    }

    public EstadoUsuario(BigDecimal nidEstadoUsuario) {
        this.nidEstadoUsuario = nidEstadoUsuario;
    }

    public BigDecimal getNidEstadoUsuario() {
        return nidEstadoUsuario;
    }

    public void setNidEstadoUsuario(BigDecimal nidEstadoUsuario) {
        this.nidEstadoUsuario = nidEstadoUsuario;
    }

    public String getTxtEstadoUsuario() {
        return txtEstadoUsuario;
    }

    public void setTxtEstadoUsuario(String txtEstadoUsuario) {
        this.txtEstadoUsuario = txtEstadoUsuario;
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
        hash += (nidEstadoUsuario != null ? nidEstadoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuario)) {
            return false;
        }
        EstadoUsuario other = (EstadoUsuario) object;
        if ((this.nidEstadoUsuario == null && other.nidEstadoUsuario != null) || (this.nidEstadoUsuario != null && !this.nidEstadoUsuario.equals(other.nidEstadoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.EstadoUsuario[ nidEstadoUsuario=" + nidEstadoUsuario + " ]";
    }
    
}
