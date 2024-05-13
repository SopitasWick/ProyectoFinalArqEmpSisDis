/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "consulta", catalog = "sistemaexpediente", schema = "")
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idConsulta", nullable = false)
    private Integer idConsulta;
    @Basic(optional = false)
    @Column(name = "idExpediente", nullable = false)
    private Integer idExpediente;
    @Basic(optional = false)
    @Column(name = "sintomas", nullable = false, length = 200)
    private String sintomas;
    @Basic(optional = false)
    @Column(name = "diagnostico", nullable = false, length = 200)
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "receta", nullable = false, length = 200)
    private String receta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsulta", fetch = FetchType.LAZY)
    private List<ExpedientePaciente> expedientePacienteList;

    public Consulta() {
    }

    public Consulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consulta(Integer idConsulta,Integer idExpediente, String sintomas, String diagnostico, String receta) {
        this.idConsulta = idConsulta;
        this.idExpediente = idExpediente;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public List<ExpedientePaciente> getExpedientePacienteList() {
        return expedientePacienteList;
    }

    public void setExpedientePacienteList(List<ExpedientePaciente> expedientePacienteList) {
        this.expedientePacienteList = expedientePacienteList;
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Consulta[ idConsulta=" + idConsulta + " ]";
    }
    
}
