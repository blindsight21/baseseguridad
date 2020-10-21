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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByNidPersona", query = "SELECT p FROM Persona p WHERE p.nidPersona = :nidPersona"),
    @NamedQuery(name = "Persona.findByTxtDocumento", query = "SELECT p FROM Persona p WHERE p.txtDocumento = :txtDocumento"),
    @NamedQuery(name = "Persona.findByTxtApellidoPaterno", query = "SELECT p FROM Persona p WHERE p.txtApellidoPaterno = :txtApellidoPaterno"),
    @NamedQuery(name = "Persona.findByTxtApellidoMaterno", query = "SELECT p FROM Persona p WHERE p.txtApellidoMaterno = :txtApellidoMaterno"),
    @NamedQuery(name = "Persona.findByTxtNombres", query = "SELECT p FROM Persona p WHERE p.txtNombres = :txtNombres"),
    @NamedQuery(name = "Persona.findByFecNacimiento", query = "SELECT p FROM Persona p WHERE p.fecNacimiento = :fecNacimiento"),
    @NamedQuery(name = "Persona.findByTxtSexo", query = "SELECT p FROM Persona p WHERE p.txtSexo = :txtSexo"),
    @NamedQuery(name = "Persona.findByNidArea", query = "SELECT p FROM Persona p WHERE p.nidArea = :nidArea"),
    @NamedQuery(name = "Persona.findByTxtFoto", query = "SELECT p FROM Persona p WHERE p.txtFoto = :txtFoto"),
    @NamedQuery(name = "Persona.findByFlgActivo", query = "SELECT p FROM Persona p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Persona.findByTxtPc", query = "SELECT p FROM Persona p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Persona.findByTxtIp", query = "SELECT p FROM Persona p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Persona.findByFecEdicion", query = "SELECT p FROM Persona p WHERE p.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Persona.findByTxtWeb", query = "SELECT p FROM Persona p WHERE p.txtWeb = :txtWeb")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PERSONA", sequenceName = "SQ_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSONA")
    @Column(name = "NID_PERSONA")
    private BigDecimal nidPersona;
//    @Size(max = 20)
    @Column(name = "TXT_DOCUMENTO")
    private String txtDocumento;
//    @Size(max = 50)
    @Column(name = "TXT_APELLIDO_PATERNO")
    private String txtApellidoPaterno;
//    @Size(max = 50)
    @Column(name = "TXT_APELLIDO_MATERNO")
    private String txtApellidoMaterno;
//    @Size(max = 50)
    @Column(name = "TXT_NOMBRES")
    private String txtNombres;
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;
//    @Size(max = 1)
    @Column(name = "TXT_SEXO")
    private String txtSexo;
    @Column(name = "NID_AREA")
    private BigInteger nidArea;
//    @Size(max = 1024)
    @Column(name = "TXT_FOTO")
    private String txtFoto;
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
//    @Size(max = 1024)
    @Column(name = "TXT_WEB")
    private String txtWeb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<DireccionPersona> direccionPersonaList;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "NID_CARGO", referencedColumnName = "NID_CARGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo cargo;
    @JoinColumn(name = "NID_TIPO_DOCUMENTO", referencedColumnName = "NID_TIPO_DOCUMENTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "NID_TIPO_PERSONA", referencedColumnName = "NID_TIPO_PERSONA")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPersona tipoPersona;
    @JoinColumn(name = "NID_USUARIO", referencedColumnName = "NID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Persona() {
    }

    public Persona(BigDecimal nidPersona) {
        this.nidPersona = nidPersona;
    }

    public BigDecimal getNidPersona() {
        return nidPersona;
    }

    public void setNidPersona(BigDecimal nidPersona) {
        this.nidPersona = nidPersona;
    }

    public String getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(String txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public String getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(String txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public String getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(String txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }

    public String getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(String txtNombres) {
        this.txtNombres = txtNombres;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getTxtSexo() {
        return txtSexo;
    }

    public void setTxtSexo(String txtSexo) {
        this.txtSexo = txtSexo;
    }

    public BigInteger getNidArea() {
        return nidArea;
    }

    public void setNidArea(BigInteger nidArea) {
        this.nidArea = nidArea;
    }

    public String getTxtFoto() {
        return txtFoto;
    }

    public void setTxtFoto(String txtFoto) {
        this.txtFoto = txtFoto;
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

    public String getTxtWeb() {
        return txtWeb;
    }

    public void setTxtWeb(String txtWeb) {
        this.txtWeb = txtWeb;
    }

    @XmlTransient
    public List<DireccionPersona> getDireccionPersonaList() {
        return direccionPersonaList;
    }

    public void setDireccionPersonaList(List<DireccionPersona> direccionPersonaList) {
        this.direccionPersonaList = direccionPersonaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
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
        hash += (nidPersona != null ? nidPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.nidPersona == null && other.nidPersona != null) || (this.nidPersona != null && !this.nidPersona.equals(other.nidPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.seguridad.modelo.Persona[ nidPersona=" + nidPersona + " ]";
    }
    
}
