/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "PERFIL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p"),
    @NamedQuery(name = "PerfilUsuario.findByNidUsuario", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "PerfilUsuario.findByNidPerfil", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.nidPerfil = :nidPerfil"),
    @NamedQuery(name = "PerfilUsuario.findByNidUsuario2", query = "SELECT p FROM PerfilUsuario p WHERE p.nidUsuario2 = :nidUsuario2"),
    @NamedQuery(name = "PerfilUsuario.findByTxtPc", query = "SELECT p FROM PerfilUsuario p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "PerfilUsuario.findByTxtIp", query = "SELECT p FROM PerfilUsuario p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "PerfilUsuario.findByFecModificacion", query = "SELECT p FROM PerfilUsuario p WHERE p.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "PerfilUsuario.findByFlgActivo", query = "SELECT p FROM PerfilUsuario p WHERE p.flgActivo = :flgActivo")})
public class PerfilUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilUsuarioPK perfilUsuarioPK;
    @Column(name = "NID_USUARIO2")
    private BigInteger nidUsuario2;
//    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Column(name = "FLG_ACTIVO")
    private Short flgActivo;
    @JoinColumn(name = "NID_PERFIL", referencedColumnName = "NID_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Perfil perfil;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public PerfilUsuario() {
    }

    public PerfilUsuario(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public PerfilUsuario(BigInteger nidUsuario, BigInteger nidPerfil) {
        this.perfilUsuarioPK = new PerfilUsuarioPK(nidUsuario, nidPerfil);
    }

    public PerfilUsuarioPK getPerfilUsuarioPK() {
        return perfilUsuarioPK;
    }

    public void setPerfilUsuarioPK(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public BigInteger getNidUsuario2() {
        return nidUsuario2;
    }

    public void setNidUsuario2(BigInteger nidUsuario2) {
        this.nidUsuario2 = nidUsuario2;
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

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public Short getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(Short flgActivo) {
        this.flgActivo = flgActivo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilUsuarioPK != null ? perfilUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.perfilUsuarioPK == null && other.perfilUsuarioPK != null) || (this.perfilUsuarioPK != null && !this.perfilUsuarioPK.equals(other.perfilUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.PerfilUsuario[ perfilUsuarioPK=" + perfilUsuarioPK + " ]";
    }
    
}
