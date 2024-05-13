/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "cita_paciente", catalog = "sistemaautenticacionps", schema = "")
@NamedQueries({
    @NamedQuery(name = "CitaPaciente.findAll", query = "SELECT c FROM CitaPaciente c")})
public class CitaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPaciente_cita", nullable = false)
    private Integer idPacientecita;
    @Basic(optional = false)
    @Column(name = "id_cita", nullable = false)
    private int idCita;
    @Basic(optional = false)
    @Column(name = "id_medico", nullable = false)
    private int idMedico;

    public CitaPaciente() {
    }

    public CitaPaciente(Integer idPacientecita) {
        this.idPacientecita = idPacientecita;
    }

    public CitaPaciente(Integer idPacientecita, int idCita,int idMedico) {
        this.idPacientecita = idPacientecita;
        this.idCita = idCita;
        this.idMedico = idMedico;
    }

    public Integer getIdPacientecita() {
        return idPacientecita;
    }

    public void setIdPacientecita(Integer idPacientecita) {
        this.idPacientecita = idPacientecita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPacientecita != null ? idPacientecita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaPaciente)) {
            return false;
        }
        CitaPaciente other = (CitaPaciente) object;
        if ((this.idPacientecita == null && other.idPacientecita != null) || (this.idPacientecita != null && !this.idPacientecita.equals(other.idPacientecita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CitaPaciente[ idPacientecita=" + idPacientecita + " ]";
    }
    
}
