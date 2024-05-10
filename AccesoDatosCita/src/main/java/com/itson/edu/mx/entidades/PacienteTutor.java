/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.entidades;

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
@Table(name = "paciente_tutor", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "PacienteTutor.findAll", query = "SELECT p FROM PacienteTutor p")})
public class PacienteTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPaciente_Tutor", nullable = false)
    private Integer idPacienteTutor;
    @JoinColumn(name = "id_paciente", referencedColumnName = "idPaciente", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idPaciente;
    @JoinColumn(name = "id_tutor", referencedColumnName = "idTutor", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tutor idTutor;

    public PacienteTutor() {
    }

    public PacienteTutor(Integer idPacienteTutor) {
        this.idPacienteTutor = idPacienteTutor;
    }

    public Integer getIdPacienteTutor() {
        return idPacienteTutor;
    }

    public void setIdPacienteTutor(Integer idPacienteTutor) {
        this.idPacienteTutor = idPacienteTutor;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Tutor getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Tutor idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPacienteTutor != null ? idPacienteTutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteTutor)) {
            return false;
        }
        PacienteTutor other = (PacienteTutor) object;
        if ((this.idPacienteTutor == null && other.idPacienteTutor != null) || (this.idPacienteTutor != null && !this.idPacienteTutor.equals(other.idPacienteTutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.PacienteTutor[ idPacienteTutor=" + idPacienteTutor + " ]";
    }
    
}
