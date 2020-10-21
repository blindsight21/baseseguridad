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
@Table(name = "FUNCIONALIDAD_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionalidadPerfil.findAll", query = "SELECT f FROM FuncionalidadPerfil f"),
    //@NamedQuery(name = "FuncionalidadPerfil.findByNidFuncionalidad", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.funcionalidadPerfilPK.nidFuncionalidad = :nidFuncionalidad"),
    //@NamedQuery(name = "FuncionalidadPerfil.findByNidPerfil", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.funcionalidadPerfilPK.nidPerfil = :nidPerfil"),
    @NamedQuery(name = "FuncionalidadPerfil.findByFlgActivo", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.flgActivo = :flgActivo"),
    @NamedQuery(name = "FuncionalidadPerfil.findByNidUsuario", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "FuncionalidadPerfil.findByTxtPc", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.txtPc = :txtPc"),
    @NamedQuery(name = "FuncionalidadPerfil.findByTxtIp", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.txtIp = :txtIp"),
    @NamedQuery(name = "FuncionalidadPerfil.findByFecEdicion", query = "SELECT f FROM FuncionalidadPerfil f WHERE f.fecEdicion = :fecEdicion")})
public class FuncionalidadPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionalidadPerfilPK funcionalidadPerfilPK;
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
    @JoinColumn(name = "NID_FUNCIONALIDAD", referencedColumnName = "NID_FUNCIONALIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionalidad funcionalidad;
    @JoinColumn(name = "NID_PERFIL", referencedColumnName = "NID_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Perfil perfil;

    public FuncionalidadPerfil() {
    }

    public FuncionalidadPerfil(FuncionalidadPerfilPK funcionalidadPerfilPK) {
        this.funcionalidadPerfilPK = funcionalidadPerfilPK;
    }

    public FuncionalidadPerfil(BigInteger nidFuncionalidad, BigInteger nidPerfil) {
        this.funcionalidadPerfilPK = new FuncionalidadPerfilPK(nidFuncionalidad, nidPerfil);
    }

    public FuncionalidadPerfilPK getFuncionalidadPerfilPK() {
        return funcionalidadPerfilPK;
    }

    public void setFuncionalidadPerfilPK(FuncionalidadPerfilPK funcionalidadPerfilPK) {
        this.funcionalidadPerfilPK = funcionalidadPerfilPK;
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

    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionalidadPerfilPK != null ? funcionalidadPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalidadPerfil)) {
            return false;
        }
        FuncionalidadPerfil other = (FuncionalidadPerfil) object;
        if ((this.funcionalidadPerfilPK == null && other.funcionalidadPerfilPK != null) || (this.funcionalidadPerfilPK != null && !this.funcionalidadPerfilPK.equals(other.funcionalidadPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.FuncionalidadPerfil[ funcionalidadPerfilPK=" + funcionalidadPerfilPK + " ]";
    }
    
}
