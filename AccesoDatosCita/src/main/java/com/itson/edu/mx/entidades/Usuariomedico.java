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
@Table(name = "usuariomedico", catalog = "sistemacita", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuariomedico.findAll", query = "SELECT u FROM Usuariomedico u")})
public class Usuariomedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmedico", nullable = false)
    private Integer idmedico;
    @Basic(optional = false)
    @Column(name = "nombreMedico", nullable = false, length = 45)
    private String nombreMedico;
    @Basic(optional = false)
    @Column(name = "tokenHuellaMedico", nullable = false, length = 45)
    private String tokenHuellaMedico;

    public Usuariomedico() {
    }

    public Usuariomedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Usuariomedico(Integer idmedico, String nombreMedico, String tokenHuellaMedico) {
        this.idmedico = idmedico;
        this.nombreMedico = nombreMedico;
        this.tokenHuellaMedico = tokenHuellaMedico;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getTokenHuellaMedico() {
        return tokenHuellaMedico;
    }

    public void setTokenHuellaMedico(String tokenHuellaMedico) {
        this.tokenHuellaMedico = tokenHuellaMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariomedico)) {
            return false;
        }
        Usuariomedico other = (Usuariomedico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.edu.mx.entidades.Usuariomedico[ idmedico=" + idmedico + " ]";
    }
    
}
