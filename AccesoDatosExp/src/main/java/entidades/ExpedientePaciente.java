/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "expediente_paciente", catalog = "sistemaexpediente", schema = "")
@NamedQueries({
    @NamedQuery(name = "ExpedientePaciente.findAll", query = "SELECT e FROM ExpedientePaciente e")})
public class ExpedientePaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idExpediente", nullable = false)
    private Integer idExpediente;
    @Basic(optional = false)
    @Column(name = "id_paciente", nullable = false)
    private int idPaciente;
    @JoinColumn(name = "id_consulta", referencedColumnName = "idConsulta", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Consulta idConsulta;

    public ExpedientePaciente() {
    }

    public ExpedientePaciente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public ExpedientePaciente(Integer idExpediente, int idPaciente) {
        this.idExpediente = idExpediente;
        this.idPaciente = idPaciente;
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Consulta getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consulta idConsulta) {
        this.idConsulta = idConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpediente != null ? idExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpedientePaciente)) {
            return false;
        }
        ExpedientePaciente other = (ExpedientePaciente) object;
        if ((this.idExpediente == null && other.idExpediente != null) || (this.idExpediente != null && !this.idExpediente.equals(other.idExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ExpedientePaciente[ idExpediente=" + idExpediente + " ]";
    }
    
}
