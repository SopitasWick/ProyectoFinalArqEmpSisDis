/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCedula;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class MedicoCedula {
    protected int idMedico;
    protected String cedula;
    protected String tokenHuella;

    public MedicoCedula() {
    }

    public MedicoCedula(int idMedico, String cedula, String tokenHuella) {
        this.idMedico = idMedico;
        this.cedula = cedula;
        this.tokenHuella = tokenHuella;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTokenHuella() {
        return tokenHuella;
    }

    public void setTokenHuella(String tokenHuella) {
        this.tokenHuella = tokenHuella;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idMedico;
        hash = 17 * hash + Objects.hashCode(this.cedula);
        hash = 17 * hash + Objects.hashCode(this.tokenHuella);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicoCedula other = (MedicoCedula) obj;
        if (this.idMedico != other.idMedico) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return Objects.equals(this.tokenHuella, other.tokenHuella);
    }

    @Override
    public String toString() {
        return "MedicoCedula{" + "idMedico=" + idMedico + ", cedula=" + cedula + ", tokenHuella=" + tokenHuella + '}';
    }
    
  }
