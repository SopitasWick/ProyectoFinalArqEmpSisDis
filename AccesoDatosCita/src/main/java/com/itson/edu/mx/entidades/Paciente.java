/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.entidades;

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
@Table(name = "paciente", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPaciente", nullable = false)
    private Integer idPaciente;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "edad", nullable = false)
    private int edad;
    @Basic(optional = false)
    @Column(name = "idExpediente", nullable = false)
    private int idExpediente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<CitaPaciente> citaPacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<UsuarioPaciente> usuarioPacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<PacienteTutor> pacienteTutorList;

    public Paciente() {
    }

    public Paciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(Integer idPaciente, String nombre, int edad, int idExpediente) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.idExpediente = idExpediente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public List<CitaPaciente> getCitaPacienteList() {
        return citaPacienteList;
    }

    public void setCitaPacienteList(List<CitaPaciente> citaPacienteList) {
        this.citaPacienteList = citaPacienteList;
    }

    public List<UsuarioPaciente> getUsuarioPacienteList() {
        return usuarioPacienteList;
    }

    public void setUsuarioPacienteList(List<UsuarioPaciente> usuarioPacienteList) {
        this.usuarioPacienteList = usuarioPacienteList;
    }

    public List<PacienteTutor> getPacienteTutorList() {
        return pacienteTutorList;
    }

    public void setPacienteTutorList(List<PacienteTutor> pacienteTutorList) {
        this.pacienteTutorList = pacienteTutorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.Paciente[ idPaciente=" + idPaciente + " ]";
    }
    
}
