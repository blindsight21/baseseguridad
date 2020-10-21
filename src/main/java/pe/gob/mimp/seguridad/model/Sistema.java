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
@Table(name = "SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findByNidSistema", query = "SELECT s FROM Sistema s WHERE s.nidSistema = :nidSistema"),
    @NamedQuery(name = "Sistema.findByTxtNombreTecnico", query = "SELECT s FROM Sistema s WHERE s.txtNombreTecnico = :txtNombreTecnico"),
    @NamedQuery(name = "Sistema.findByTxtNombre", query = "SELECT s FROM Sistema s WHERE s.txtNombre = :txtNombre"),
    @NamedQuery(name = "Sistema.findByTxtAlias", query = "SELECT s FROM Sistema s WHERE s.txtAlias = :txtAlias"),
    @NamedQuery(name = "Sistema.findByFlgEstado", query = "SELECT s FROM Sistema s WHERE s.flgEstado = :flgEstado"),
    @NamedQuery(name = "Sistema.findByFlgActivo", query = "SELECT s FROM Sistema s WHERE s.flgActivo = :flgActivo"),
    @NamedQuery(name = "Sistema.findByTxtPc", query = "SELECT s FROM Sistema s WHERE s.txtPc = :txtPc"),
    @NamedQuery(name = "Sistema.findByTxtIp", query = "SELECT s FROM Sistema s WHERE s.txtIp = :txtIp"),
    @NamedQuery(name = "Sistema.findByFecEdicion", query = "SELECT s FROM Sistema s WHERE s.fecEdicion = :fecEdicion")})
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_SISTEMA", sequenceName = "SQ_SISTEMA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @Column(name = "NID_SISTEMA")
    private BigDecimal nidSistema;
//    @Size(max = 20)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistema", fetch = FetchType.LAZY)
    private List<Modulo> moduloList;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Sistema() {
    }

    public Sistema(BigDecimal nidSistema) {
        this.nidSistema = nidSistema;
    }

    public BigDecimal getNidSistema() {
        return nidSistema;
    }

    public void setNidSistema(BigDecimal nidSistema) {
        this.nidSistema = nidSistema;
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

    @XmlTransient
    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
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
        hash += (nidSistema != null ? nidSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.nidSistema == null && other.nidSistema != null) || (this.nidSistema != null && !this.nidSistema.equals(other.nidSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Sistema[ nidSistema=" + nidSistema + " ]";
    }
    
}
