/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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
@Table(name = "cedula_profesional", catalog = "sistemacedulas", schema = "")
@NamedQueries({
    @NamedQuery(name = "CedulaProfesional.findAll", query = "SELECT c FROM CedulaProfesional c")})
public class CedulaProfesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCedulaProfesional", nullable = false)
    private Integer idCedulaProfesional;
    @Basic(optional = false)
    @Column(name = "cedula", nullable = false, length = 45)
    private String cedula;
    @Basic(optional = false)
    @Column(name = "id_medico", nullable = false)
    private int idMedico;

    public CedulaProfesional() {
    }

    public CedulaProfesional(Integer idCedulaProfesional) {
        this.idCedulaProfesional = idCedulaProfesional;
    }

    public CedulaProfesional(Integer idCedulaProfesional, String cedula, int idMedico) {
        this.idCedulaProfesional = idCedulaProfesional;
        this.cedula = cedula;
        this.idMedico = idMedico;
    }

    public Integer getIdCedulaProfesional() {
        return idCedulaProfesional;
    }

    public void setIdCedulaProfesional(Integer idCedulaProfesional) {
        this.idCedulaProfesional = idCedulaProfesional;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
        hash += (idCedulaProfesional != null ? idCedulaProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CedulaProfesional)) {
            return false;
        }
        CedulaProfesional other = (CedulaProfesional) object;
        if ((this.idCedulaProfesional == null && other.idCedulaProfesional != null) || (this.idCedulaProfesional != null && !this.idCedulaProfesional.equals(other.idCedulaProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CedulaProfesional[ idCedulaProfesional=" + idCedulaProfesional + " ]";
    }
    
}
