/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.entidades;

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
@Table(name = "cita", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcita", nullable = false)
    private Integer idcita;
    @Basic(optional = false)
    @Column(name = "idMedico", nullable = false)
    private int idMedico;
    @Basic(optional = false)
    @Column(name = "idPaciente", nullable = false)
    private int idPaciente;
    @Basic(optional = false)
    @Column(name = "fechaCita", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCita;

    public Cita() {
    }

    public Cita(Integer idcita) {
        this.idcita = idcita;
    }

    public Cita(Integer idcita, int idMedico, int idPaciente, Date fechaCita) {
        this.idcita = idcita;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.Cita[ idcita=" + idcita + " ]";
    }
    
}
