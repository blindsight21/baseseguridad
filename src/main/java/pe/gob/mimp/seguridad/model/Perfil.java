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
import javax.persistence.CascadeType;
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
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByNidPerfil", query = "SELECT p FROM Perfil p WHERE p.nidPerfil = :nidPerfil"),
    @NamedQuery(name = "Perfil.findByTxtPerfil", query = "SELECT p FROM Perfil p WHERE p.txtPerfil = :txtPerfil"),
    @NamedQuery(name = "Perfil.findByFlgActivo", query = "SELECT p FROM Perfil p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Perfil.findByTxtPc", query = "SELECT p FROM Perfil p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Perfil.findByTxtIp", query = "SELECT p FROM Perfil p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Perfil.findByFecEdicion", query = "SELECT p FROM Perfil p WHERE p.fecEdicion = :fecEdicion")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PERFIL", sequenceName = "SQ_PERFIL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERFIL")
    @Column(name = "NID_PERFIL")
    private BigDecimal nidPerfil;
//    @Size(max = 256)
    @Column(name = "TXT_PERFIL")
    private String txtPerfil;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
//    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil", fetch = FetchType.LAZY)
    private List<FuncionalidadPerfil> funcionalidadPerfilList;
    @JoinColumn(name = "NID_MODULO", referencedColumnName = "NID_MODULO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Modulo modulo;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil", fetch = FetchType.LAZY)
    private List<PerfilUsuario> perfilUsuarioList;

    public Perfil() {
    }

    public Perfil(BigDecimal nidPerfil) {
        this.nidPerfil = nidPerfil;
    }

    public BigDecimal getNidPerfil() {
        return nidPerfil;
    }

    public void setNidPerfil(BigDecimal nidPerfil) {
        this.nidPerfil = nidPerfil;
    }

    public String getTxtPerfil() {
        return txtPerfil;
    }

    public void setTxtPerfil(String txtPerfil) {
        this.txtPerfil = txtPerfil;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
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
    public List<FuncionalidadPerfil> getFuncionalidadPerfilList() {
        return funcionalidadPerfilList;
    }

    public void setFuncionalidadPerfilList(List<FuncionalidadPerfil> funcionalidadPerfilList) {
        this.funcionalidadPerfilList = funcionalidadPerfilList;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<PerfilUsuario> getPerfilUsuarioList() {
        return perfilUsuarioList;
    }

    public void setPerfilUsuarioList(List<PerfilUsuario> perfilUsuarioList) {
        this.perfilUsuarioList = perfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPerfil != null ? nidPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.nidPerfil == null && other.nidPerfil != null) || (this.nidPerfil != null && !this.nidPerfil.equals(other.nidPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Perfil[ nidPerfil=" + nidPerfil + " ]";
    }
    
}
