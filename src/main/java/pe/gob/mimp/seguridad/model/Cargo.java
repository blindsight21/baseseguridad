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
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByNidCargo", query = "SELECT c FROM Cargo c WHERE c.nidCargo = :nidCargo"),
    @NamedQuery(name = "Cargo.findByTxtDescripcion", query = "SELECT c FROM Cargo c WHERE c.txtDescripcion = :txtDescripcion"),
    @NamedQuery(name = "Cargo.findByFlgActivo", query = "SELECT c FROM Cargo c WHERE c.flgActivo = :flgActivo"),
    @NamedQuery(name = "Cargo.findByTxtPc", query = "SELECT c FROM Cargo c WHERE c.txtPc = :txtPc"),
    @NamedQuery(name = "Cargo.findByTxtIp", query = "SELECT c FROM Cargo c WHERE c.txtIp = :txtIp"),
    @NamedQuery(name = "Cargo.findByFecEdicion", query = "SELECT c FROM Cargo c WHERE c.fecEdicion = :fecEdicion")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_CARGO", sequenceName = "SQ_CARGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARGO")
    @Column(name = "NID_CARGO")
    private BigDecimal nidCargo;
//    @Size(max = 20)
    @Column(name = "TXT_DESCRIPCION")
    private String txtDescripcion;
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
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    private List<Persona> personaList;

    public Cargo() {
    }

    public Cargo(BigDecimal nidCargo) {
        this.nidCargo = nidCargo;
    }

    public BigDecimal getNidCargo() {
        return nidCargo;
    }

    public void setNidCargo(BigDecimal nidCargo) {
        this.nidCargo = nidCargo;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
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

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidCargo != null ? nidCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.nidCargo == null && other.nidCargo != null) || (this.nidCargo != null && !this.nidCargo.equals(other.nidCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Cargo[ nidCargo=" + nidCargo + " ]";
    }
    
}
