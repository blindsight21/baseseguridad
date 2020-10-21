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
@Table(name = "FUNCIONALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f"),
    @NamedQuery(name = "Funcionalidad.findByNidFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.nidFuncionalidad = :nidFuncionalidad"),
    @NamedQuery(name = "Funcionalidad.findByNidFuncionalidadPadre", query = "SELECT f FROM Funcionalidad f WHERE f.nidFuncionalidadPadre = :nidFuncionalidadPadre"),
    @NamedQuery(name = "Funcionalidad.findByTxtTitulo", query = "SELECT f FROM Funcionalidad f WHERE f.txtTitulo = :txtTitulo"),
    @NamedQuery(name = "Funcionalidad.findByTxtFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.txtFuncionalidad = :txtFuncionalidad"),
    @NamedQuery(name = "Funcionalidad.findByTxtReferencia", query = "SELECT f FROM Funcionalidad f WHERE f.txtReferencia = :txtReferencia"),
    @NamedQuery(name = "Funcionalidad.findByTxtTarget", query = "SELECT f FROM Funcionalidad f WHERE f.txtTarget = :txtTarget"),
    @NamedQuery(name = "Funcionalidad.findByTxtCss", query = "SELECT f FROM Funcionalidad f WHERE f.txtCss = :txtCss"),
    @NamedQuery(name = "Funcionalidad.findByTxtImagen", query = "SELECT f FROM Funcionalidad f WHERE f.txtImagen = :txtImagen"),
    @NamedQuery(name = "Funcionalidad.findByNumOrden", query = "SELECT f FROM Funcionalidad f WHERE f.numOrden = :numOrden"),
    @NamedQuery(name = "Funcionalidad.findByFlgEstado", query = "SELECT f FROM Funcionalidad f WHERE f.flgEstado = :flgEstado"),
    @NamedQuery(name = "Funcionalidad.findByFlgActivo", query = "SELECT f FROM Funcionalidad f WHERE f.flgActivo = :flgActivo"),
    @NamedQuery(name = "Funcionalidad.findByTxtPc", query = "SELECT f FROM Funcionalidad f WHERE f.txtPc = :txtPc"),
    @NamedQuery(name = "Funcionalidad.findByTxtIp", query = "SELECT f FROM Funcionalidad f WHERE f.txtIp = :txtIp"),
    @NamedQuery(name = "Funcionalidad.findByFecEdicion", query = "SELECT f FROM Funcionalidad f WHERE f.fecEdicion = :fecEdicion")})
public class Funcionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_FUNCIONALIDAD", sequenceName = "SQ_FUNCIONALIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCIONALIDAD")
    @Column(name = "NID_FUNCIONALIDAD")
    private BigDecimal nidFuncionalidad;
    @Column(name = "NID_FUNCIONALIDAD_PADRE")
    private BigInteger nidFuncionalidadPadre;
//    @Size(max = 128)
    @Column(name = "TXT_TITULO")
    private String txtTitulo;
//    @Size(max = 128)
    @Column(name = "TXT_FUNCIONALIDAD")
    private String txtFuncionalidad;
//    @Size(max = 256)
    @Column(name = "TXT_REFERENCIA")
    private String txtReferencia;
//    @Size(max = 20)
    @Column(name = "TXT_TARGET")
    private String txtTarget;
//    @Size(max = 50)
    @Column(name = "TXT_CSS")
    private String txtCss;
//    @Size(max = 256)
    @Column(name = "TXT_IMAGEN")
    private String txtImagen;
    @Column(name = "NUM_ORDEN")
    private BigInteger numOrden;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionalidad", fetch = FetchType.LAZY)
    private List<FuncionalidadPerfil> funcionalidadPerfilList;
    @JoinColumn(name = "NID_MODULO", referencedColumnName = "NID_MODULO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Modulo modulo;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Funcionalidad() {
    }

    public Funcionalidad(BigDecimal nidFuncionalidad) {
        this.nidFuncionalidad = nidFuncionalidad;
    }

    public BigDecimal getNidFuncionalidad() {
        return nidFuncionalidad;
    }

    public void setNidFuncionalidad(BigDecimal nidFuncionalidad) {
        this.nidFuncionalidad = nidFuncionalidad;
    }

    public BigInteger getNidFuncionalidadPadre() {
        return nidFuncionalidadPadre;
    }

    public void setNidFuncionalidadPadre(BigInteger nidFuncionalidadPadre) {
        this.nidFuncionalidadPadre = nidFuncionalidadPadre;
    }

    public String getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(String txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public String getTxtFuncionalidad() {
        return txtFuncionalidad;
    }

    public void setTxtFuncionalidad(String txtFuncionalidad) {
        this.txtFuncionalidad = txtFuncionalidad;
    }

    public String getTxtReferencia() {
        return txtReferencia;
    }

    public void setTxtReferencia(String txtReferencia) {
        this.txtReferencia = txtReferencia;
    }

    public String getTxtTarget() {
        return txtTarget;
    }

    public void setTxtTarget(String txtTarget) {
        this.txtTarget = txtTarget;
    }

    public String getTxtCss() {
        return txtCss;
    }

    public void setTxtCss(String txtCss) {
        this.txtCss = txtCss;
    }

    public String getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(String txtImagen) {
        this.txtImagen = txtImagen;
    }

    public BigInteger getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(BigInteger numOrden) {
        this.numOrden = numOrden;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidFuncionalidad != null ? nidFuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.nidFuncionalidad == null && other.nidFuncionalidad != null) || (this.nidFuncionalidad != null && !this.nidFuncionalidad.equals(other.nidFuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Funcionalidad[ nidFuncionalidad=" + nidFuncionalidad + " ]";
    }
    
}
