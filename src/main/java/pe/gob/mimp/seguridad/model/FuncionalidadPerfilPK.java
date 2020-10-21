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
public class FuncionalidadPerfilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_FUNCIONALIDAD")
    private BigInteger nidFuncionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_PERFIL")
    private BigInteger nidPerfil;

    public FuncionalidadPerfilPK() {
    }

    public FuncionalidadPerfilPK(BigInteger nidFuncionalidad, BigInteger nidPerfil) {
        this.nidFuncionalidad = nidFuncionalidad;
        this.nidPerfil = nidPerfil;
    }

    public BigInteger getNidFuncionalidad() {
        return nidFuncionalidad;
    }

    public void setNidFuncionalidad(BigInteger nidFuncionalidad) {
        this.nidFuncionalidad = nidFuncionalidad;
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
        hash += (nidFuncionalidad != null ? nidFuncionalidad.hashCode() : 0);
        hash += (nidPerfil != null ? nidPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalidadPerfilPK)) {
            return false;
        }
        FuncionalidadPerfilPK other = (FuncionalidadPerfilPK) object;
        if ((this.nidFuncionalidad == null && other.nidFuncionalidad != null) || (this.nidFuncionalidad != null && !this.nidFuncionalidad.equals(other.nidFuncionalidad))) {
            return false;
        }
        if ((this.nidPerfil == null && other.nidPerfil != null) || (this.nidPerfil != null && !this.nidPerfil.equals(other.nidPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.FuncionalidadPerfilPK[ nidFuncionalidad=" + nidFuncionalidad + ", nidPerfil=" + nidPerfil + " ]";
    }
    
}
