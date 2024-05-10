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
@Table(name = "usuario_paciente", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "UsuarioPaciente.findAll", query = "SELECT u FROM UsuarioPaciente u")})
public class UsuarioPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsuario_Paciente", nullable = false)
    private Integer idUsuarioPaciente;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idPaciente;

    public UsuarioPaciente() {
    }

    public UsuarioPaciente(Integer idUsuarioPaciente) {
        this.idUsuarioPaciente = idUsuarioPaciente;
    }

    public UsuarioPaciente(Integer idUsuarioPaciente, String nombre, String password) {
        this.idUsuarioPaciente = idUsuarioPaciente;
        this.nombre = nombre;
        this.password = password;
    }

    public Integer getIdUsuarioPaciente() {
        return idUsuarioPaciente;
    }

    public void setIdUsuarioPaciente(Integer idUsuarioPaciente) {
        this.idUsuarioPaciente = idUsuarioPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioPaciente != null ? idUsuarioPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPaciente)) {
            return false;
        }
        UsuarioPaciente other = (UsuarioPaciente) object;
        if ((this.idUsuarioPaciente == null && other.idUsuarioPaciente != null) || (this.idUsuarioPaciente != null && !this.idUsuarioPaciente.equals(other.idUsuarioPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.UsuarioPaciente[ idUsuarioPaciente=" + idUsuarioPaciente + " ]";
    }
    
}
