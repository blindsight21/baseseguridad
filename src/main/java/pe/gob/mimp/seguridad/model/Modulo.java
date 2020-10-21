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
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByNidModulo", query = "SELECT m FROM Modulo m WHERE m.nidModulo = :nidModulo"),
    @NamedQuery(name = "Modulo.findByTxtNombreTecnico", query = "SELECT m FROM Modulo m WHERE m.txtNombreTecnico = :txtNombreTecnico"),
    @NamedQuery(name = "Modulo.findByTxtNombre", query = "SELECT m FROM Modulo m WHERE m.txtNombre = :txtNombre"),
    @NamedQuery(name = "Modulo.findByTxtAlias", query = "SELECT m FROM Modulo m WHERE m.txtAlias = :txtAlias"),
    @NamedQuery(name = "Modulo.findByFlgEstado", query = "SELECT m FROM Modulo m WHERE m.flgEstado = :flgEstado"),
    @NamedQuery(name = "Modulo.findByFlgActivo", query = "SELECT m FROM Modulo m WHERE m.flgActivo = :flgActivo"),
    @NamedQuery(name = "Modulo.findByTxtPc", query = "SELECT m FROM Modulo m WHERE m.txtPc = :txtPc"),
    @NamedQuery(name = "Modulo.findByTxtIp", query = "SELECT m FROM Modulo m WHERE m.txtIp = :txtIp"),
    @NamedQuery(name = "Modulo.findByFecEdicion", query = "SELECT m FROM Modulo m WHERE m.fecEdicion = :fecEdicion")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_MODULO", sequenceName = "SQ_MODULO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MODULO")
    @Column(name = "NID_MODULO")
    private BigDecimal nidModulo;
//    @Size(max = 50)
    @Column(name = "TXT_NOMBRE_TECNICO")
    private String txtNombreTecnico;
//    @Size(max = 128)
    @Column(name = "TXT_NOMBRE")
    private String txtNombre;
//    @Size(max = 128)
    @Column(name = "TXT_ALIAS")
    private String txtAlias;
    @Column(name = "FLG_ESTADO")
    private BigInteger flgEstado;
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
    @JoinColumn(name = "NID_SISTEMA", referencedColumnName = "NID_SISTEMA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sistema sistema;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<Funcionalidad> funcionalidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<Perfil> perfilList;

    public Modulo() {
    }

    public Modulo(BigDecimal nidModulo) {
        this.nidModulo = nidModulo;
    }

    public BigDecimal getNidModulo() {
        return nidModulo;
    }

    public void setNidModulo(BigDecimal nidModulo) {
        this.nidModulo = nidModulo;
    }

    public String getTxtNombreTecnico() {
        return txtNombreTecnico;
    }

    public void setTxtNombreTecnico(String txtNombreTecnico) {
        this.txtNombreTecnico = txtNombreTecnico;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtAlias() {
        return txtAlias;
    }

    public void setTxtAlias(String txtAlias) {
        this.txtAlias = txtAlias;
    }

    public BigInteger getFlgEstado() {
        return flgEstado;
    }

    public void setFlgEstado(BigInteger flgEstado) {
        this.flgEstado = flgEstado;
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

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Funcionalidad> getFuncionalidadList() {
        return funcionalidadList;
    }

    public void setFuncionalidadList(List<Funcionalidad> funcionalidadList) {
        this.funcionalidadList = funcionalidadList;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidModulo != null ? nidModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.nidModulo == null && other.nidModulo != null) || (this.nidModulo != null && !this.nidModulo.equals(other.nidModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Modulo[ nidModulo=" + nidModulo + " ]";
    }
    
}
