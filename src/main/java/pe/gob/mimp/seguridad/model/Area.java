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
@Table(name = "AREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByNidArea", query = "SELECT a FROM Area a WHERE a.nidArea = :nidArea"),
    @NamedQuery(name = "Area.findByTxtArea", query = "SELECT a FROM Area a WHERE a.txtArea = :txtArea"),
    @NamedQuery(name = "Area.findByFlgActivo", query = "SELECT a FROM Area a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "Area.findByTxtPc", query = "SELECT a FROM Area a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "Area.findByTxtIp", query = "SELECT a FROM Area a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "Area.findByFecEdicion", query = "SELECT a FROM Area a WHERE a.fecEdicion = :fecEdicion")})
public class Area implements Serializable {
    @OneToMany(mappedBy = "nidArea", fetch = FetchType.LAZY)
    private List<SalaMimp> salaMimpList;
    @OneToMany(mappedBy = "nidArea", fetch = FetchType.LAZY)
    private List<ServicioMimp> servicioMimpList;

    @OneToMany(mappedBy = "nidArea", fetch = FetchType.LAZY)
    private List<Trabajador> trabajadorList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_AREA", sequenceName = "SQ_AREA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AREA")
    @Column(name = "NID_AREA")
    private BigDecimal nidArea;
//    @Size(max = 256)
    @Column(name = "TXT_AREA")
    private String txtArea;
    @Column(name = "NID_AREA_PADRE")
    private BigInteger nidAreaPadre;
//    @Size(max = 2)
    @Column(name = "NUM_PISO")
    private String numPiso;
//    @Size(max = 20)
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
//    @Size(max = 64)
    @Column(name = "TXT_SIGLA")
    private String txtSigla;
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Area() {
    }

    public Area(BigDecimal nidArea) {
        this.nidArea = nidArea;
    }

    public BigDecimal getNidArea() {
        return nidArea;
    }

    public void setNidArea(BigDecimal nidArea) {
        this.nidArea = nidArea;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidArea != null ? nidArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.nidArea == null && other.nidArea != null) || (this.nidArea != null && !this.nidArea.equals(other.nidArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Area[ nidArea=" + nidArea + " ]";
    }

    public String getTxtSigla() {
        return txtSigla;
    }

    public void setTxtSigla(String txtSigla) {
        this.txtSigla = txtSigla;
    }

    public BigInteger getNidAreaPadre() {
        return nidAreaPadre;
    }

    public void setNidAreaPadre(BigInteger nidAreaPadre) {
        this.nidAreaPadre = nidAreaPadre;
    }

    public String getNumPiso() {
        return numPiso;
    }

    public void setNumTxtPiso(String numPiso) {
        this.numPiso = numPiso;
    }

    @XmlTransient
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @XmlTransient
    public List<SalaMimp> getSalaMimpList() {
        return salaMimpList;
    }

    public void setSalaMimpList(List<SalaMimp> salaMimpList) {
        this.salaMimpList = salaMimpList;
    }

    @XmlTransient
    public List<ServicioMimp> getServicioMimpList() {
        return servicioMimpList;
    }

    public void setServicioMimpList(List<ServicioMimp> servicioMimpList) {
        this.servicioMimpList = servicioMimpList;
    }
}
