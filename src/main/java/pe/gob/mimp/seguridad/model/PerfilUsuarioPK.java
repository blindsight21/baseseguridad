/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.seguridad.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author desarrollador
 */
@Embeddable
public class PerfilUsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_PERFIL")
    private BigInteger nidPerfil;

    public PerfilUsuarioPK() {
    }

    public PerfilUsuarioPK(BigInteger nidUsuario, BigInteger nidPerfil) {
        this.nidUsuario = nidUsuario;
        this.nidPerfil = nidPerfil;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public BigInteger getNidPerfil() {
        return nidPerfil;
    }

    public void setNidPerfil(BigInteger nidPerfil) {
        this.nidPerfil = nidPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidUsuario != null ? nidUsuario.hashCode() : 0);
        hash += (nidPerfil != null ? nidPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuarioPK)) {
            return false;
        }
        PerfilUsuarioPK other = (PerfilUsuarioPK) object;
        if ((this.nidUsuario == null && other.nidUsuario != null) || (this.nidUsuario != null && !this.nidUsuario.equals(other.nidUsuario))) {
            return false;
        }
        if ((this.nidPerfil == null && other.nidPerfil != null) || (this.nidPerfil != null && !this.nidPerfil.equals(other.nidPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.PerfilUsuarioPK[ nidUsuario=" + nidUsuario + ", nidPerfil=" + nidPerfil + " ]";
    }
    
}
