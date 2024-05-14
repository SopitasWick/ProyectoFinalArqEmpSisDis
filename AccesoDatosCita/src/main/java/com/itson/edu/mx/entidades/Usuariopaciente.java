/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "usuariopaciente", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuariopaciente.findAll", query = "SELECT u FROM Usuariopaciente u")})
public class Usuariopaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpaciente", nullable = false)
    private Integer idpaciente;
    @Basic(optional = false)
    @Column(name = "nombrePaciente", nullable = false, length = 45)
    private String nombrePaciente;
    @Basic(optional = false)
    @Column(name = "tokenHuellaPaciente", nullable = false, length = 45)
    private String tokenHuellaPaciente;

    public Usuariopaciente() {
    }

    public Usuariopaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Usuariopaciente(Integer idpaciente, String nombrePaciente, String tokenHuellaPaciente) {
        this.idpaciente = idpaciente;
        this.nombrePaciente = nombrePaciente;
        this.tokenHuellaPaciente = tokenHuellaPaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTokenHuellaPaciente() {
        return tokenHuellaPaciente;
    }

    public void setTokenHuellaPaciente(String tokenHuellaPaciente) {
        this.tokenHuellaPaciente = tokenHuellaPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopaciente)) {
            return false;
        }
        Usuariopaciente other = (Usuariopaciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.Usuariopaciente[ idpaciente=" + idpaciente + " ]";
    }
    
}
