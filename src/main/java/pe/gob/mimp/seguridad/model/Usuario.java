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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNidUsuario", query = "SELECT u FROM Usuario u WHERE u.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Usuario.findByTxtUsuario", query = "SELECT u FROM Usuario u WHERE u.txtUsuario = :txtUsuario"),
    @NamedQuery(name = "Usuario.findByTxtPassword", query = "SELECT u FROM Usuario u WHERE u.txtPassword = :txtPassword"),
    @NamedQuery(name = "Usuario.findByFlgActivo", query = "SELECT u FROM Usuario u WHERE u.flgActivo = :flgActivo"),
    @NamedQuery(name = "Usuario.findByNidUsuario2", query = "SELECT u FROM Usuario u WHERE u.nidUsuario2 = :nidUsuario2"),
    @NamedQuery(name = "Usuario.findByTxtPc", query = "SELECT u FROM Usuario u WHERE u.txtPc = :txtPc"),
    @NamedQuery(name = "Usuario.findByTxtIp", query = "SELECT u FROM Usuario u WHERE u.txtIp = :txtIp"),
    @NamedQuery(name = "Usuario.findByFecEdicion", query = "SELECT u FROM Usuario u WHERE u.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Usuario.findByNidEstadoUsuario", query = "SELECT u FROM Usuario u WHERE u.nidEstadoUsuario = :nidEstadoUsuario"),
    @NamedQuery(name = "Usuario.findByFecUltimo", query = "SELECT u FROM Usuario u WHERE u.fecUltimo = :fecUltimo")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @Column(name = "NID_USUARIO")
    private BigDecimal nidUsuario;
//    @Size(max = 50)
    @Column(name = "TXT_USUARIO")
    private String txtUsuario;
//    @Size(max = 256)
    @Column(name = "TXT_PASSWORD")
    private String txtPassword;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO2")
    private BigInteger nidUsuario2;
//    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ESTADO_USUARIO")
    private BigInteger nidEstadoUsuario;
    @Column(name = "FEC_ULTIMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltimo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Modulo> moduloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Sistema> sistemaList;
    @JoinColumn(name = "NID_PERSONA", referencedColumnName = "NID_PERSONA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Cargo> cargoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Area> areaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Funcionalidad> funcionalidadList;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<TipoDocumento> tipoDocumentoList;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Perfil> perfilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<PerfilUsuario> perfilUsuarioList;

    public Usuario() {
    }

    public Usuario(BigDecimal nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public Usuario(BigDecimal nidUsuario, BigInteger nidEstadoUsuario) {
        this.nidUsuario = nidUsuario;
        this.nidEstadoUsuario = nidEstadoUsuario;
    }

    public BigDecimal getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigDecimal nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(String txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
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

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    public BigInteger getNidEstadoUsuario() {
        return nidEstadoUsuario;
    }

    public void setNidEstadoUsuario(BigInteger nidEstadoUsuario) {
        this.nidEstadoUsuario = nidEstadoUsuario;
    }

    public Date getFecUltimo() {
        return fecUltimo;
    }

    public void setFecUltimo(Date fecUltimo) {
        this.fecUltimo = fecUltimo;
    }

    @XmlTransient
    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    @XmlTransient
    public List<Sistema> getSistemaList() {
        return sistemaList;
    }

    public void setSistemaList(List<Sistema> sistemaList) {
        this.sistemaList = sistemaList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Funcionalidad> getFuncionalidadList() {
        return funcionalidadList;
    }

    public void setFuncionalidadList(List<Funcionalidad> funcionalidadList) {
        this.funcionalidadList = funcionalidadList;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<TipoDocumento> getTipoDocumentoList() {
        return tipoDocumentoList;
    }

    public void setTipoDocumentoList(List<TipoDocumento> tipoDocumentoList) {
        this.tipoDocumentoList = tipoDocumentoList;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
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
        hash += (nidUsuario != null ? nidUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nidUsuario == null && other.nidUsuario != null) || (this.nidUsuario != null && !this.nidUsuario.equals(other.nidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Usuario[ nidUsuario=" + nidUsuario + " ]";
    }
    
}
